// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-08-24 17:49:43

    //import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "TIMES", "OVER", "REM", "SEMI", "OPEN_P", "CLOSE_P", "PRINT", "NUM", "SPACE"
    };
    public static final int PRINT=12;
    public static final int TIMES=6;
    public static final int NUM=13;
    public static final int SEMI=9;
    public static final int OPEN_P=10;
    public static final int MINUS=5;
    public static final int SPACE=14;
    public static final int OVER=7;
    public static final int CLOSE_P=11;
    public static final int REM=8;
    public static final int EOF=-1;
    public static final int PLUS=4;

    // delegates
    // delegators


        public BaliParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BaliParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BaliParser.tokenNames; }
    public String getGrammarFileName() { return "Bali.g"; }


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



    // $ANTLR start "program"
    // Bali.g:50:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // Bali.g:51:5: ( ( statement )+ )
            // Bali.g:51:9: ( statement )+
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
                    ".method public static main([Ljava/lang/String;)V\n\n");
                    
            // Bali.g:63:9: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PRINT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bali.g:63:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program231);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

             System.out.println(
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


    // $ANTLR start "statement"
    // Bali.g:74:1: statement : st_print ;
    public final void statement() throws RecognitionException {
        try {
            // Bali.g:75:5: ( st_print )
            // Bali.g:75:7: st_print
            {
            pushFollow(FOLLOW_st_print_in_statement260);
            st_print();

            state._fsp--;


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
    // $ANTLR end "statement"


    // $ANTLR start "st_print"
    // Bali.g:78:1: st_print : PRINT exp_arithmetic SEMI ;
    public final void st_print() throws RecognitionException {
        try {
            // Bali.g:79:5: ( PRINT exp_arithmetic SEMI )
            // Bali.g:80:5: PRINT exp_arithmetic SEMI
            {
            match(input,PRINT,FOLLOW_PRINT_in_st_print282); 
             System.out.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n"); 
            pushFollow(FOLLOW_exp_arithmetic_in_st_print295);
            exp_arithmetic();

            state._fsp--;

             System.out.println("\tinvokevirtual java/io/PrintStream/println(I)V\n\n"); 
            match(input,SEMI,FOLLOW_SEMI_in_st_print307); 

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
    // $ANTLR end "st_print"


    // $ANTLR start "exp_arithmetic"
    // Bali.g:87:1: exp_arithmetic : term (op= ( PLUS | MINUS ) term )* ;
    public final void exp_arithmetic() throws RecognitionException {
        Token op=null;

        try {
            // Bali.g:88:5: ( term (op= ( PLUS | MINUS ) term )* )
            // Bali.g:88:7: term (op= ( PLUS | MINUS ) term )*
            {
            pushFollow(FOLLOW_term_in_exp_arithmetic324);
            term();

            state._fsp--;

            // Bali.g:88:12: (op= ( PLUS | MINUS ) term )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=PLUS && LA2_0<=MINUS)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Bali.g:88:14: op= ( PLUS | MINUS ) term
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_term_in_exp_arithmetic342);
            	    term();

            	    state._fsp--;

            	     System.out.println(((op!=null?op.getType():0) == PLUS) ? "\t\tiadd":"\t\tisubt"); 

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
    // $ANTLR end "exp_arithmetic"


    // $ANTLR start "term"
    // Bali.g:92:1: term : factor (op= ( TIMES | OVER | REM ) factor )* ;
    public final void term() throws RecognitionException {
        Token op=null;

        try {
            // Bali.g:93:5: ( factor (op= ( TIMES | OVER | REM ) factor )* )
            // Bali.g:93:7: factor (op= ( TIMES | OVER | REM ) factor )*
            {
            pushFollow(FOLLOW_factor_in_term374);
            factor();

            state._fsp--;

            // Bali.g:93:14: (op= ( TIMES | OVER | REM ) factor )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=TIMES && LA3_0<=REM)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bali.g:93:16: op= ( TIMES | OVER | REM ) factor
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=TIMES && input.LA(1)<=REM) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor_in_term395);
            	    factor();

            	    state._fsp--;


            	          
            	          if((op!=null?op.getType():0) == TIMES)
            	            System.out.println("\t\timul"); 
            	          else if((op!=null?op.getType():0) == OVER)
            	            System.out.println("\t\tidiv");
            	          else
            	            System.out.println("\t\tirem"); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // Bali.g:104:1: factor : ( NUM | OPEN_P exp_arithmetic CLOSE_P );
    public final void factor() throws RecognitionException {
        Token NUM1=null;

        try {
            // Bali.g:105:5: ( NUM | OPEN_P exp_arithmetic CLOSE_P )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NUM) ) {
                alt4=1;
            }
            else if ( (LA4_0==OPEN_P) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // Bali.g:105:9: NUM
                    {
                    NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_factor423); 
                     System.out.println("\t\tldc " + (NUM1!=null?NUM1.getText():null)); 

                    }
                    break;
                case 2 :
                    // Bali.g:107:7: OPEN_P exp_arithmetic CLOSE_P
                    {
                    match(input,OPEN_P,FOLLOW_OPEN_P_in_factor441); 
                    pushFollow(FOLLOW_exp_arithmetic_in_factor443);
                    exp_arithmetic();

                    state._fsp--;

                    match(input,CLOSE_P,FOLLOW_CLOSE_P_in_factor445); 

                    }
                    break;

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


 

    public static final BitSet FOLLOW_statement_in_program231 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_st_print_in_statement260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_st_print282 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_print295 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMI_in_st_print307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic324 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_set_in_exp_arithmetic332 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic342 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_factor_in_term374 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_set_in_term382 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_factor_in_term395 = new BitSet(new long[]{0x00000000000001C2L});
    public static final BitSet FOLLOW_NUM_in_factor423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_P_in_factor441 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_factor443 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_CLOSE_P_in_factor445 = new BitSet(new long[]{0x0000000000000002L});

}