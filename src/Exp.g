grammar Exp;

/*---------------- TOKEN DEFINITIONS ----------------*/

tokens
{
    PLUS    = '+' ;
    TIMES   = '*' ;
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
        ExpLexer lexer = new ExpLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);

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
        ".method public static main([Ljava/lang/String;)V\n"+
            "\t; empilha System.out\n"+
            "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n\n");
        }
        expression
        { System.out.println(
            "\t; chama o metodo PrintStream.println(), usando os dois valores da pilha\n"+
            "\tinvokevirtual java/io/PrintStream/println(I)V\n\n"+

            "\t; finaliza o metodo\n"+
            "\treturn\n\n"+
    
        "; indica que no maximo tres itens podem ser colocados na pilha\n"+
        ".limit stack 10\n"+
        ".end method\n"); 
        }
    ;

expression
    :   term ( PLUS term { System.out.println("\tiadd"); } )*
    ;

term    
    :   factor ( TIMES factor { System.out.println("\timul"); } )*
    ;
    
factor
    :   NUM
        { System.out.println("\tldc " + $NUM.text); }
    ;

