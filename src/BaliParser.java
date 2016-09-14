// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-09-14 17:43:37

    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTR", "PLUS", "MINUS", "TIMES", "OVER", "REM", "OPEN_P", "CLOSE_P", "PRINT", "NUM", "SPACE", "VAR", "NL"
    };
    public static final int PRINT=12;
    public static final int TIMES=7;
    public static final int VAR=15;
    public static final int NUM=13;
    public static final int OPEN_P=10;
    public static final int ATTR=4;
    public static final int MINUS=6;
    public static final int SPACE=14;
    public static final int OVER=8;
    public static final int CLOSE_P=11;
    public static final int REM=9;
    public static final int EOF=-1;
    public static final int NL=16;
    public static final int PLUS=5;

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



    // $ANTLR start "program"
    // Bali.g:75:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // Bali.g:76:5: ( ( statement )+ )
            // Bali.g:76:9: ( statement )+
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
                    
            // Bali.g:88:9: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PRINT||(LA1_0>=VAR && LA1_0<=NL)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bali.g:88:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program257);
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
                        "\treturn\n\n"+
                    ".limit stack " + max_stack +"\n"+
                    ".limit locals " + symbol_table.size() + "\n"+
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
    // Bali.g:97:1: statement : ( NL | st_attr | st_print );
    public final void statement() throws RecognitionException {
        try {
            // Bali.g:98:5: ( NL | st_attr | st_print )
            int alt2=3;
            switch ( input.LA(1) ) {
            case NL:
                {
                alt2=1;
                }
                break;
            case VAR:
                {
                alt2=2;
                }
                break;
            case PRINT:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // Bali.g:98:7: NL
                    {
                    match(input,NL,FOLLOW_NL_in_statement286); 

                    }
                    break;
                case 2 :
                    // Bali.g:98:12: st_attr
                    {
                    pushFollow(FOLLOW_st_attr_in_statement290);
                    st_attr();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // Bali.g:98:22: st_print
                    {
                    pushFollow(FOLLOW_st_print_in_statement294);
                    st_print();

                    state._fsp--;


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
    // $ANTLR end "statement"


    // $ANTLR start "st_attr"
    // Bali.g:101:1: st_attr : VAR ATTR exp_arithmetic NL ;
    public final void st_attr() throws RecognitionException {
        Token VAR1=null;

        try {
            // Bali.g:102:5: ( VAR ATTR exp_arithmetic NL )
            // Bali.g:102:7: VAR ATTR exp_arithmetic NL
            {
            VAR1=(Token)match(input,VAR,FOLLOW_VAR_in_st_attr311); 
            match(input,ATTR,FOLLOW_ATTR_in_st_attr313); 
            pushFollow(FOLLOW_exp_arithmetic_in_st_attr315);
            exp_arithmetic();

            state._fsp--;

            match(input,NL,FOLLOW_NL_in_st_attr317); 

                    emit("\t\tistore " + createVariable((VAR1!=null?VAR1.getText():null)), -1);
                

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
    // $ANTLR end "st_attr"


    // $ANTLR start "st_print"
    // Bali.g:108:1: st_print : PRINT exp_arithmetic NL ;
    public final void st_print() throws RecognitionException {
        try {
            // Bali.g:109:5: ( PRINT exp_arithmetic NL )
            // Bali.g:110:5: PRINT exp_arithmetic NL
            {
            match(input,PRINT,FOLLOW_PRINT_in_st_print345); 
             emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); 
            pushFollow(FOLLOW_exp_arithmetic_in_st_print358);
            exp_arithmetic();

            state._fsp--;

             emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2); 
            match(input,NL,FOLLOW_NL_in_st_print370); 

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
    // Bali.g:117:1: exp_arithmetic : term (op= ( PLUS | MINUS ) term )* ;
    public final void exp_arithmetic() throws RecognitionException {
        Token op=null;

        try {
            // Bali.g:118:5: ( term (op= ( PLUS | MINUS ) term )* )
            // Bali.g:118:7: term (op= ( PLUS | MINUS ) term )*
            {
            pushFollow(FOLLOW_term_in_exp_arithmetic387);
            term();

            state._fsp--;

            // Bali.g:118:12: (op= ( PLUS | MINUS ) term )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=PLUS && LA3_0<=MINUS)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bali.g:118:14: op= ( PLUS | MINUS ) term
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

            	    pushFollow(FOLLOW_term_in_exp_arithmetic405);
            	    term();

            	    state._fsp--;

            	     emit(((op!=null?op.getType():0) == PLUS) ? "\t\tiadd":"\t\tisubt", -1); 

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
    // $ANTLR end "exp_arithmetic"


    // $ANTLR start "term"
    // Bali.g:122:1: term : factor (op= ( TIMES | OVER | REM ) factor )* ;
    public final void term() throws RecognitionException {
        Token op=null;

        try {
            // Bali.g:123:5: ( factor (op= ( TIMES | OVER | REM ) factor )* )
            // Bali.g:123:7: factor (op= ( TIMES | OVER | REM ) factor )*
            {
            pushFollow(FOLLOW_factor_in_term437);
            factor();

            state._fsp--;

            // Bali.g:123:14: (op= ( TIMES | OVER | REM ) factor )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=TIMES && LA4_0<=REM)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bali.g:123:16: op= ( TIMES | OVER | REM ) factor
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

            	    pushFollow(FOLLOW_factor_in_term458);
            	    factor();

            	    state._fsp--;


            	          
            	          if((op!=null?op.getType():0) == TIMES)
            	            emit("\t\timul", -1); 
            	          else if((op!=null?op.getType():0) == OVER)
            	            emit("\t\tidiv", -1);
            	          else
            	            emit("\t\tirem", -1); 
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // Bali.g:134:1: factor : ( NUM | OPEN_P exp_arithmetic CLOSE_P | VAR );
    public final void factor() throws RecognitionException {
        Token NUM2=null;
        Token VAR3=null;

        try {
            // Bali.g:135:5: ( NUM | OPEN_P exp_arithmetic CLOSE_P | VAR )
            int alt5=3;
            switch ( input.LA(1) ) {
            case NUM:
                {
                alt5=1;
                }
                break;
            case OPEN_P:
                {
                alt5=2;
                }
                break;
            case VAR:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Bali.g:135:9: NUM
                    {
                    NUM2=(Token)match(input,NUM,FOLLOW_NUM_in_factor486); 
                     emit("\t\tldc " + (NUM2!=null?NUM2.getText():null), 1); 

                    }
                    break;
                case 2 :
                    // Bali.g:137:7: OPEN_P exp_arithmetic CLOSE_P
                    {
                    match(input,OPEN_P,FOLLOW_OPEN_P_in_factor504); 
                    pushFollow(FOLLOW_exp_arithmetic_in_factor506);
                    exp_arithmetic();

                    state._fsp--;

                    match(input,CLOSE_P,FOLLOW_CLOSE_P_in_factor508); 

                    }
                    break;
                case 3 :
                    // Bali.g:138:9: VAR
                    {
                    VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_factor518); 
                     
                                emit("\t\tiload " + findVariable((VAR3!=null?VAR3.getText():null)), +1);
                            

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


 

    public static final BitSet FOLLOW_statement_in_program257 = new BitSet(new long[]{0x0000000000019002L});
    public static final BitSet FOLLOW_NL_in_statement286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_attr_in_statement290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_print_in_statement294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_st_attr311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ATTR_in_st_attr313 = new BitSet(new long[]{0x000000000000A400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_attr315 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NL_in_st_attr317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_st_print345 = new BitSet(new long[]{0x000000000000A400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_print358 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NL_in_st_print370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic387 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_set_in_exp_arithmetic395 = new BitSet(new long[]{0x000000000000A400L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic405 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_factor_in_term437 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_set_in_term445 = new BitSet(new long[]{0x000000000000A400L});
    public static final BitSet FOLLOW_factor_in_term458 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_NUM_in_factor486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_P_in_factor504 = new BitSet(new long[]{0x000000000000A400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_factor506 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_CLOSE_P_in_factor508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_factor518 = new BitSet(new long[]{0x0000000000000002L});

}