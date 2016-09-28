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
    OPEN_P  = '(' ;
    CLOSE_P = ')' ;
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
    
    public static int stack = 0, max_stack = 0;

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
        }
        return symbol_table.indexOf(symbol);
    }

    public static int findVariable(String symbol) {
        if(!symbol_table.contains(symbol)) {
           System.err.println("Variable " + symbol + " not declared");
           System.exit(3);
        }
        return symbol_table.indexOf(symbol);
    }
}

/*---------------- LEXER RULES ----------------*/

NUM     : '0'..'9'+('.' '0'..'9'+)? ;
SPACE   : (' '|'\t')+ { skip(); } ;
STR     : '"'~('"')*'"';
VAR     : 'a'..'z'+ ;
NL      : ('\r')?'\n';


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
        }
    ;

statement
    : NL | st_attr | st_print
    ;

st_attr
    : VAR ATTR (exp = exp_arithmetic) NL
    {
        System.err.println("Tipo " + $exp.type);
        if($exp.type == 'i'){
            emit("\t\tistore " + createVariable($VAR.text, 'i'), -1);
        }
        else{
            emit("\t\tastore " + createVariable($VAR.text, 's'), -1);
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

exp_arithmetic returns [char type]
    : l_term = term {
        if($l_term.type == 'i')
            $type = 'i';
        else
            $type = 's';
      } 
      ( op = ( PLUS | MINUS ) r_term = term {
        if($l_term.type == 's' || $r_term.type == 's') {
            System.err.println("Invalid statement sucker");
            System.exit(3);
        }
        else{
            $type = 'i';
            emit(($op.type == PLUS) ? "\t\tiadd":"\t\tisubt", -1);
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
            $type = 's';
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

