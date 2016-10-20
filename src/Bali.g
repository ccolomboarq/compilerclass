grammar Bali;

/*---------------- TOKEN DEFINITIONS ----------------*/

tokens
{
    ATTR    = '=' ;
    PLUS    = '+' ;
    MINUS   = '-' ;
    TIMES   = '*' ;
    OVER    = '/' ;
    REM     = '%' ;
    EQ      = '==';
    NE      = '!=';
    GT      = '>' ;
    GE      = '>=';
    LT      = '<' ;
    LE      = '<=';
    OPEN_P  = '(' ;
    CLOSE_P = ')' ;
    OPEN_C  = '{' ;
    CLOSE_C = '}' ;
    WHILE   = 'while';
    PRINT   = 'print' ;
    READINT = 'read_int' ;
    READSTR = 'read_str' ;
}

/*---------------- COMPILER INTERNALS ----------------*/

@header
{
    import java.util.ArrayList;
}

@members
{
    private static ArrayList<String> symbol_table;
    private static ArrayList<Character> type_table;
    private static ArrayList<Boolean> used_table;
    
    public static int stack = 0, max_stack = 0, while_counter = 0;

    public static void main(String[] args) throws Exception
    {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        BaliLexer lexer = new BaliLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BaliParser parser = new BaliParser(tokens);

        symbol_table = new ArrayList<String>();
        symbol_table.add("args");

        type_table = new ArrayList<Character>();
        type_table.add('S');

        used_table = new ArrayList<Boolean>();
        used_table.add(true);
        parser.program();
        System.out.println("; symbols: " + symbol_table);
    }

    public static void emit(String bytecode, int delta){
        System.out.println(bytecode);
        stack += delta;
        if(stack > max_stack)
            max_stack = stack;
    }

    public static int createVariable(String symbol, char type) {
        if(!symbol_table.contains(symbol)) {
            symbol_table.add(symbol);
            type_table.add(type);
            used_table.add(false);
        }
        return symbol_table.indexOf(symbol);
    }

    public static int findVariable(String symbol) {
        if(!symbol_table.contains(symbol)) {
           System.err.println("Variable " + symbol + " not declared");
           System.exit(3);
        }
        used_table.set(symbol_table.indexOf(symbol), true);
        return symbol_table.indexOf(symbol);
    }
}

/*---------------- LEXER RULES ----------------*/

NUM     : '0'..'9'+('.' '0'..'9'+)? ;
STR     : '"'~('"')*'"';
VAR     : 'a'..'z'+ ;
COMMENT : '#' ~('\n')* { skip(); };
NL      : ('\r')?'\n';
SPACE   : (' '|'\t')+ { skip(); } ;


/*---------------- PARSER RULES ----------------*/

program
    :   { System.out.println(
        ".source Test.j\n"+
        ".class  public Test\n"+
        ".super  java/lang/Object\n\n"+
        
        ".method public <init>()V\n"+
            "\taload_0\n"+
            "\tinvokenonvirtual java/lang/Object/<init>()V\n"+
            "\treturn\n"+
        ".end method\n\n"+
        ".method public static main([Ljava/lang/String;)V\n\n");
        }
        (statement)+
        { System.out.println(
            "\treturn\n\n"+
        ".limit stack " + max_stack +"\n"+
        ".limit locals " + symbol_table.size() + "\n"+
        ".end method\n");
            for(int i = 0; i < used_table.size(); i++) {
                if(!used_table.get(i))
                    System.err.println("warning: Variable '" + symbol_table.get(i) + "' not used");    
            }
        }
    ;

statement
    : NL | st_attr | st_print | st_while
    ;

st_attr
    : VAR ATTR (exp = exp_arithmetic) NL
    {
        if($exp.type == 'i'){
            if(!symbol_table.contains($VAR.text)) {
                emit("\t\tistore " + createVariable($VAR.text, 'i'), -1);
            }
            else {
                if(type_table.get(findVariable($VAR.text)) != 'i') {
                    System.err.println("error: Variable '" + $VAR.text + "' is string");
                    System.exit(3);
                }
                else {
                    emit("\t\tistore " + createVariable($VAR.text, 'i'), -1);    
                }
            }
        }
        else{
            if(!symbol_table.contains($VAR.text)) {
                emit("\t\tastore " + createVariable($VAR.text, 's'), -1);
            }
            else {
                if(type_table.get(findVariable($VAR.text)) != 's') {
                    System.err.println("error: Variable '" + $VAR.text + "' is integer");
                    System.exit(3);
                }
                else {
                    emit("\t\tastore " + createVariable($VAR.text, 's'), -1);    
                }
            }
        }
    }
    ;

st_print
    : 
    PRINT { 
        emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); 
    } 
    exp = exp_arithmetic {
        if($exp.type == 'i')
            emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2);
        else
            emit("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n", -2); 
    }
    NL
    ;

st_while
    :
    WHILE {
        emit("BEGIN_WHILE_" + ++while_counter + ":", 0);
    }
    conditional = exp_conditional OPEN_C NL {
        //System.err.println($conditional.type)
        emit($conditional.type + " " + "END_WHILE_" + while_counter + " ;", -2);
    } 
    (statement)* 
    CLOSE_C {
        emit("\t\tgoto BEGIN_WHILE_" + while_counter + " ;", 0);
        emit("END_WHILE_" + while_counter + ":", 0);
    }
    NL
    ;

exp_conditional returns [String type]
    :
    l_exp = exp_arithmetic op = (EQ | NE | GT | GE | LT | LE) r_exp = exp_arithmetic {
        if($l_exp.type != 'i' || $r_exp.type != 'i'){
            System.err.println("Can't apply operator on string!");
            System.exit(3);
        }
        if($op.type == EQ){
            $type = "if_icmpne";
        }
        else if($op.type == NE) {
            $type = "if_icmpeq";
        }
        else if($op.type == GT) {
            $type = "if_icmple";
        }
        else if($op.type == GE) {
            $type = "if_icmplt";
        }
        else if($op.type == LT) {
            $type = "if_icmpge";
        }
        else if($op.type == LE) {
            $type = "if_icmpgt";
        }
    }
    ;

exp_arithmetic returns [char type]
    : l_term = term {
        if($l_term.type == 'i')
            $type = 'i';
        else
            $type = 's';
      } 
      ( op = ( PLUS | MINUS ) r_term = term {
        if($l_term.type == 's' || $r_term.type == 's') {
            System.err.println("Can't apply operator on string!");
            System.exit(3);
        }
        else{
            $type = 'i';
            emit(($op.type == PLUS) ? "\t\tiadd":"\t\tisub", -1);
        }
    })*
    ;

term returns [char type]    
    : l_fact = factor {
        if($l_fact.type == 'i')
            $type = 'i';
        else
            $type = 's';
      } 

      ( op = ( TIMES | OVER | REM) r_fact = factor {
        if($l_fact.type == 's' || $r_fact.type == 's') {
            System.err.println("Can't apply operator on string!");
            System.exit(3);
        }
        else{
            $type = 'i';

            if($op.type == TIMES)
                emit("\t\timul", -1); 
            else if($op.type == OVER)
                emit("\t\tidiv", -1);
            else
                emit("\t\tirem", -1);
        }
    } )*
    ;
    
factor returns [char type]
    :   NUM { 
            emit("\t\tldc " + $NUM.text, 1);
            $type = 'i';
        }
    |	OPEN_P (exp = exp_arithmetic) CLOSE_P {
            $type = $exp.type;
        }
    |   VAR {
            int index = findVariable($VAR.text);
            if(type_table.get(index) == 'i') {
                emit("\t\tiload " + index, 1);
            }
            else {
                emit("\t\taload " + index, 1);
            }
            $type = type_table.get(index);
        }
    |   READINT {
            emit("\tinvokestatic Runtime/readInt()I ;", 1);
            $type = 'i';
        }
    |   READSTR {
            emit("\tinvokestatic Runtime/readString()Ljava/lang/String;", 1);
            $type = 's';
        }
    |   STR {
            emit("\t\tldc " + $STR.text, 1);
        }
    ;

