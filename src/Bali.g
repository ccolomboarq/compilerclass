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
}

/*---------------- COMPILER INTERNALS ----------------*/

@header
{
    import java.util.ArrayList;
}

@members
{
    private static ArrayList<String> symbol_table;

    public static int stack = 0, max_stack = 0;

    public static void main(String[] args) throws Exception
    {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        BaliLexer lexer = new BaliLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BaliParser parser = new BaliParser(tokens);

        symbol_table = new ArrayList<String>();
        symbol_table.add("args");       
        parser.program();
        System.out.println("; symbols: " + symbol_table);
    }

    public static void emit(String bytecode, int delta){
        System.out.println(bytecode);
        stack += delta;
        if(stack > max_stack)
            max_stack = stack;
    }

    public static int createVariable(String symbol) {
        if(!symbol_table.contains(symbol))
            symbol_table.add(symbol);
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
    : VAR ATTR exp_arithmetic NL
    {
        emit("\t\tistore " + createVariable($VAR.text), -1);
    }
    ;

st_print
    : 
    PRINT
    { emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); } 
    exp_arithmetic
    { emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2); }
    NL
    ;

exp_arithmetic
    : term ( op = ( PLUS | MINUS ) term 
      { emit(($op.type == PLUS) ? "\t\tiadd":"\t\tisubt", -1); })*
    ;

term    
    : factor ( op = ( TIMES | OVER | REM) factor {
      
      if($op.type == TIMES)
        emit("\t\timul", -1); 
      else if($op.type == OVER)
        emit("\t\tidiv", -1);
      else
        emit("\t\tirem", -1); 
    } )*
    ;
    
factor
    :   NUM
        { emit("\t\tldc " + $NUM.text, 1); }
    |	OPEN_P exp_arithmetic CLOSE_P
    |   VAR { 
            emit("\t\tiload " + findVariable($VAR.text), +1);
        }
    ;

