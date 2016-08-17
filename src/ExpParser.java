// $ANTLR 3.2 Sep 23, 2009 12:02:23 Exp.g 2016-08-17 17:52:58

    //import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "TIMES", "NUM", "SPACE"
    };
    public static final int TIMES=5;
    public static final int NUM=6;
    public static final int SPACE=7;
    public static final int EOF=-1;
    public static final int PLUS=4;

    // delegates
    // delegators


        public ExpParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExpParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExpParser.tokenNames; }
    public String getGrammarFileName() { return "Exp.g"; }


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



    // $ANTLR start "program"
    // Exp.g:43:1: program : expression ;
    public final void program() throws RecognitionException {
        try {
            // Exp.g:44:5: ( expression )
            // Exp.g:44:9: expression
            {
             System.out.println(
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
                    
            pushFollow(FOLLOW_expression_in_program131);
            expression();

            state._fsp--;

             System.out.println(
                        "\t; chama o metodo PrintStream.println(), usando os dois valores da pilha\n"+
                        "\tinvokevirtual java/io/PrintStream/println(I)V\n\n"+

                        "\t; finaliza o metodo\n"+
                        "\treturn\n\n"+
                
                    "; indica que no maximo tres itens podem ser colocados na pilha\n"+
                    ".limit stack 10\n"+
                    ".end method\n"); 
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "expression"
    // Exp.g:72:1: expression : term ( PLUS term )* ;
    public final void expression() throws RecognitionException {
        try {
            // Exp.g:73:5: ( term ( PLUS term )* )
            // Exp.g:73:9: term ( PLUS term )*
            {
            pushFollow(FOLLOW_term_in_expression160);
            term();

            state._fsp--;

            // Exp.g:73:14: ( PLUS term )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PLUS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Exp.g:73:16: PLUS term
            	    {
            	    match(input,PLUS,FOLLOW_PLUS_in_expression164); 
            	    pushFollow(FOLLOW_term_in_expression166);
            	    term();

            	    state._fsp--;

            	     System.out.println("\tiadd"); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "term"
    // Exp.g:76:1: term : factor ( TIMES factor )* ;
    public final void term() throws RecognitionException {
        try {
            // Exp.g:77:5: ( factor ( TIMES factor )* )
            // Exp.g:77:9: factor ( TIMES factor )*
            {
            pushFollow(FOLLOW_factor_in_term194);
            factor();

            state._fsp--;

            // Exp.g:77:16: ( TIMES factor )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TIMES) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Exp.g:77:18: TIMES factor
            	    {
            	    match(input,TIMES,FOLLOW_TIMES_in_term198); 
            	    pushFollow(FOLLOW_factor_in_term200);
            	    factor();

            	    state._fsp--;

            	     System.out.println("\timul"); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "term"


    // $ANTLR start "factor"
    // Exp.g:80:1: factor : NUM ;
    public final void factor() throws RecognitionException {
        Token NUM1=null;

        try {
            // Exp.g:81:5: ( NUM )
            // Exp.g:81:9: NUM
            {
            NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_factor228); 
             System.out.println("\tldc " + (NUM1!=null?NUM1.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "factor"

    // Delegated rules


 

    public static final BitSet FOLLOW_expression_in_program131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_expression160 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_PLUS_in_expression164 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_term_in_expression166 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_factor_in_term194 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_TIMES_in_term198 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_factor_in_term200 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_NUM_in_factor228 = new BitSet(new long[]{0x0000000000000002L});

}