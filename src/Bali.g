grammar Bali;

/*---------------- TOKEN DEFINITIONS ----------------*/

tokens
{
    PLUS    = '+' ;
    MINUS   = '-' ;
    TIMES   = '*' ;
    OVER    = '/' ;
    REM     = '%' ;
    SEMI    = ';' ;
    OPEN_P  = '(' ;
    CLOSE_P = ')' ;
    PRINT   = 'print' ;
}

/*---------------- COMPILER INTERNALS ----------------*/

@header
{
    //import java.util.ArrayList;
}

@members
{
    //private static ArrayList<String> symbol_table;

    public static void main(String[] args) throws Exception
    {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        BaliLexer lexer = new BaliLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BaliParser parser = new BaliParser(tokens);

        //symbol_table = new ArrayList<String>();        
        parser.program();
        //System.out.println("symbols: " + symbol_table);
    }
}

/*---------------- LEXER RULES ----------------*/

NUM     : '0'..'9'+('.' '0'..'9'+)? ;
SPACE   : (' '|'\t'|'\r'|'\n')+ { skip(); } ;


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
            "\t; finaliza o metodo\n"+
            "\treturn\n\n"+
    
        "; indica que no maximo tres itens podem ser colocados na pilha\n"+
        ".limit stack 10\n"+
        ".end method\n"); 
        }
    ;

statement
    : st_print
    ;

st_print
    : 
    PRINT
    { System.out.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n"); } 
    exp_arithmetic
    { System.out.println("\tinvokevirtual java/io/PrintStream/println(I)V\n\n"); }
    SEMI
    ;

exp_arithmetic
    : term ( op = ( PLUS | MINUS ) term 
      { System.out.println(($op.type == PLUS) ? "\t\tiadd":"\t\tisubt"); })*
    ;

term    
    : factor ( op = ( TIMES | OVER | REM) factor {
      
      if($op.type == TIMES)
        System.out.println("\t\timul"); 
      else if($op.type == OVER)
        System.out.println("\t\tidiv");
      else
        System.out.println("\t\tirem"); 
    } )*
    ;
    
factor
    :   NUM
        { System.out.println("\t\tldc " + $NUM.text); }
    |	OPEN_P exp_arithmetic CLOSE_P
    ;

