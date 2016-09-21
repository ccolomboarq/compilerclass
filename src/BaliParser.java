// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-09-21 17:44:28

    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTR", "PLUS", "MINUS", "TIMES", "OVER", "REM", "OPEN_P", "CLOSE_P", "PRINT", "READINT", "READSTR", "NUM", "SPACE", "VAR", "NL", "STR"
    };
    public static final int PRINT=12;
    public static final int VAR=17;
    public static final int READINT=13;
    public static final int READSTR=14;
    public static final int OPEN_P=10;
    public static final int MINUS=6;
    public static final int SPACE=16;
    public static final int STR=19;
    public static final int CLOSE_P=11;
    public static final int EOF=-1;
    public static final int TIMES=7;
    public static final int NUM=15;
    public static final int ATTR=4;
    public static final int OVER=8;
    public static final int REM=9;
    public static final int NL=18;
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
    // Bali.g:78:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // Bali.g:79:5: ( ( statement )+ )
            // Bali.g:79:9: ( statement )+
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
                    
            // Bali.g:91:9: ( statement )+
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
            	    // Bali.g:91:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program298);
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
    // Bali.g:100:1: statement : ( NL | st_attr | st_print );
    public final void statement() throws RecognitionException {
        try {
            // Bali.g:101:5: ( NL | st_attr | st_print )
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
                    // Bali.g:101:7: NL
                    {
                    match(input,NL,FOLLOW_NL_in_statement327); 

                    }
                    break;
                case 2 :
                    // Bali.g:101:12: st_attr
                    {
                    pushFollow(FOLLOW_st_attr_in_statement331);
                    st_attr();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // Bali.g:101:22: st_print
                    {
                    pushFollow(FOLLOW_st_print_in_statement335);
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
    // Bali.g:104:1: st_attr : VAR ATTR exp_arithmetic NL ;
    public final void st_attr() throws RecognitionException {
        Token VAR1=null;

        try {
            // Bali.g:105:5: ( VAR ATTR exp_arithmetic NL )
            // Bali.g:105:7: VAR ATTR exp_arithmetic NL
            {
            VAR1=(Token)match(input,VAR,FOLLOW_VAR_in_st_attr352); 
            match(input,ATTR,FOLLOW_ATTR_in_st_attr354); 
            pushFollow(FOLLOW_exp_arithmetic_in_st_attr356);
            exp_arithmetic();

            state._fsp--;

            match(input,NL,FOLLOW_NL_in_st_attr358); 

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
    // Bali.g:111:1: st_print : PRINT exp_arithmetic NL ;
    public final void st_print() throws RecognitionException {
        try {
            // Bali.g:112:5: ( PRINT exp_arithmetic NL )
            // Bali.g:113:5: PRINT exp_arithmetic NL
            {
            match(input,PRINT,FOLLOW_PRINT_in_st_print386); 
             emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); 
            pushFollow(FOLLOW_exp_arithmetic_in_st_print399);
            exp_arithmetic();

            state._fsp--;

             emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2); 
            match(input,NL,FOLLOW_NL_in_st_print411); 

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
    // Bali.g:120:1: exp_arithmetic : term (op= ( PLUS | MINUS ) term )* ;
    public final void exp_arithmetic() throws RecognitionException {
        Token op=null;

        try {
            // Bali.g:121:5: ( term (op= ( PLUS | MINUS ) term )* )
            // Bali.g:121:7: term (op= ( PLUS | MINUS ) term )*
            {
            pushFollow(FOLLOW_term_in_exp_arithmetic428);
            term();

            state._fsp--;

            // Bali.g:121:12: (op= ( PLUS | MINUS ) term )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=PLUS && LA3_0<=MINUS)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bali.g:121:14: op= ( PLUS | MINUS ) term
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

            	    pushFollow(FOLLOW_term_in_exp_arithmetic446);
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
    // Bali.g:125:1: term : factor (op= ( TIMES | OVER | REM ) factor )* ;
    public final void term() throws RecognitionException {
        Token op=null;

        try {
            // Bali.g:126:5: ( factor (op= ( TIMES | OVER | REM ) factor )* )
            // Bali.g:126:7: factor (op= ( TIMES | OVER | REM ) factor )*
            {
            pushFollow(FOLLOW_factor_in_term478);
            factor();

            state._fsp--;

            // Bali.g:126:14: (op= ( TIMES | OVER | REM ) factor )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=TIMES && LA4_0<=REM)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bali.g:126:16: op= ( TIMES | OVER | REM ) factor
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

            	    pushFollow(FOLLOW_factor_in_term499);
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
    // Bali.g:137:1: factor : ( NUM | OPEN_P exp_arithmetic CLOSE_P | VAR | READINT | READSTR | STR );
    public final void factor() throws RecognitionException {
        Token NUM2=null;
        Token VAR3=null;
        Token STR4=null;

        try {
            // Bali.g:138:5: ( NUM | OPEN_P exp_arithmetic CLOSE_P | VAR | READINT | READSTR | STR )
            int alt5=6;
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
            case READINT:
                {
                alt5=4;
                }
                break;
            case READSTR:
                {
                alt5=5;
                }
                break;
            case STR:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Bali.g:138:9: NUM
                    {
                    NUM2=(Token)match(input,NUM,FOLLOW_NUM_in_factor527); 
                     emit("\t\tldc " + (NUM2!=null?NUM2.getText():null), 1); 

                    }
                    break;
                case 2 :
                    // Bali.g:140:7: OPEN_P exp_arithmetic CLOSE_P
                    {
                    match(input,OPEN_P,FOLLOW_OPEN_P_in_factor545); 
                    pushFollow(FOLLOW_exp_arithmetic_in_factor547);
                    exp_arithmetic();

                    state._fsp--;

                    match(input,CLOSE_P,FOLLOW_CLOSE_P_in_factor549); 

                    }
                    break;
                case 3 :
                    // Bali.g:141:9: VAR
                    {
                    VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_factor559); 
                     
                                emit("\t\tiload " + findVariable((VAR3!=null?VAR3.getText():null)), 1);
                            

                    }
                    break;
                case 4 :
                    // Bali.g:144:9: READINT
                    {
                    match(input,READINT,FOLLOW_READINT_in_factor571); 

                                emit("\tinvokestatic Runtime/readInt()I ;", 1);
                            

                    }
                    break;
                case 5 :
                    // Bali.g:147:9: READSTR
                    {
                    match(input,READSTR,FOLLOW_READSTR_in_factor583); 

                                emit("\tinvokestatic Runtime/readString()Ljava/lang/String;", 1);
                            

                    }
                    break;
                case 6 :
                    // Bali.g:150:9: STR
                    {
                    STR4=(Token)match(input,STR,FOLLOW_STR_in_factor595); 

                                emit("\t\taload " + findVariable((STR4!=null?STR4.getText():null)), 1);
                            

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


 

    public static final BitSet FOLLOW_statement_in_program298 = new BitSet(new long[]{0x0000000000061002L});
    public static final BitSet FOLLOW_NL_in_statement327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_attr_in_statement331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_print_in_statement335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_st_attr352 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ATTR_in_st_attr354 = new BitSet(new long[]{0x00000000000AE400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_attr356 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_NL_in_st_attr358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_st_print386 = new BitSet(new long[]{0x00000000000AE400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_print399 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_NL_in_st_print411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic428 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_set_in_exp_arithmetic436 = new BitSet(new long[]{0x00000000000AE400L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic446 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_factor_in_term478 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_set_in_term486 = new BitSet(new long[]{0x00000000000AE400L});
    public static final BitSet FOLLOW_factor_in_term499 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_NUM_in_factor527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_P_in_factor545 = new BitSet(new long[]{0x00000000000AE400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_factor547 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_CLOSE_P_in_factor549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_factor559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READINT_in_factor571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READSTR_in_factor583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_factor595 = new BitSet(new long[]{0x0000000000000002L});

}