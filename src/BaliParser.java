// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-09-28 14:56:28

    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTR", "PLUS", "MINUS", "TIMES", "OVER", "REM", "OPEN_P", "CLOSE_P", "PRINT", "READINT", "READSTR", "NUM", "SPACE", "STR", "VAR", "NL"
    };
    public static final int PRINT=12;
    public static final int VAR=18;
    public static final int READINT=13;
    public static final int READSTR=14;
    public static final int OPEN_P=10;
    public static final int MINUS=6;
    public static final int SPACE=16;
    public static final int STR=17;
    public static final int CLOSE_P=11;
    public static final int EOF=-1;
    public static final int TIMES=7;
    public static final int NUM=15;
    public static final int ATTR=4;
    public static final int OVER=8;
    public static final int REM=9;
    public static final int NL=19;
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



    // $ANTLR start "program"
    // Bali.g:85:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // Bali.g:86:5: ( ( statement )+ )
            // Bali.g:86:9: ( statement )+
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
                    
            // Bali.g:98:9: ( statement )+
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
            	    // Bali.g:98:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program299);
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
    // Bali.g:107:1: statement : ( NL | st_attr | st_print );
    public final void statement() throws RecognitionException {
        try {
            // Bali.g:108:5: ( NL | st_attr | st_print )
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
                    // Bali.g:108:7: NL
                    {
                    match(input,NL,FOLLOW_NL_in_statement328); 

                    }
                    break;
                case 2 :
                    // Bali.g:108:12: st_attr
                    {
                    pushFollow(FOLLOW_st_attr_in_statement332);
                    st_attr();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // Bali.g:108:22: st_print
                    {
                    pushFollow(FOLLOW_st_print_in_statement336);
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
    // Bali.g:111:1: st_attr : VAR ATTR (exp= exp_arithmetic ) NL ;
    public final void st_attr() throws RecognitionException {
        Token VAR1=null;
        char exp = 0;


        try {
            // Bali.g:112:5: ( VAR ATTR (exp= exp_arithmetic ) NL )
            // Bali.g:112:7: VAR ATTR (exp= exp_arithmetic ) NL
            {
            VAR1=(Token)match(input,VAR,FOLLOW_VAR_in_st_attr353); 
            match(input,ATTR,FOLLOW_ATTR_in_st_attr355); 
            // Bali.g:112:16: (exp= exp_arithmetic )
            // Bali.g:112:17: exp= exp_arithmetic
            {
            pushFollow(FOLLOW_exp_arithmetic_in_st_attr362);
            exp=exp_arithmetic();

            state._fsp--;


            }

            match(input,NL,FOLLOW_NL_in_st_attr365); 

                    System.err.println("Tipo " + exp);
                    if(exp == 'i'){
                        emit("\t\tistore " + createVariable((VAR1!=null?VAR1.getText():null), 'i'), -1);
                    }
                    else{
                        emit("\t\tastore " + createVariable((VAR1!=null?VAR1.getText():null), 's'), -1);
                    }
                

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
    // Bali.g:124:1: st_print : PRINT exp= exp_arithmetic NL ;
    public final void st_print() throws RecognitionException {
        char exp = 0;


        try {
            // Bali.g:125:5: ( PRINT exp= exp_arithmetic NL )
            // Bali.g:126:5: PRINT exp= exp_arithmetic NL
            {
            match(input,PRINT,FOLLOW_PRINT_in_st_print393); 
             
                    emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); 
                
            pushFollow(FOLLOW_exp_arithmetic_in_st_print406);
            exp=exp_arithmetic();

            state._fsp--;


                    if(exp == 'i')
                        emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2);
                    else
                        emit("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n", -2); 
                
            match(input,NL,FOLLOW_NL_in_st_print414); 

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
    // Bali.g:138:1: exp_arithmetic returns [char type] : l_term= term (op= ( PLUS | MINUS ) r_term= term )* ;
    public final char exp_arithmetic() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_term = 0;

        char r_term = 0;


        try {
            // Bali.g:139:5: (l_term= term (op= ( PLUS | MINUS ) r_term= term )* )
            // Bali.g:139:7: l_term= term (op= ( PLUS | MINUS ) r_term= term )*
            {
            pushFollow(FOLLOW_term_in_exp_arithmetic439);
            l_term=term();

            state._fsp--;


                    if(l_term == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:145:7: (op= ( PLUS | MINUS ) r_term= term )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=PLUS && LA3_0<=MINUS)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bali.g:145:9: op= ( PLUS | MINUS ) r_term= term
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

            	    pushFollow(FOLLOW_term_in_exp_arithmetic470);
            	    r_term=term();

            	    state._fsp--;


            	            if(l_term == 's' || r_term == 's') {
            	                System.err.println("Invalid statement sucker");
            	                System.exit(3);
            	            }
            	            else{
            	                type = 'i';
            	                emit(((op!=null?op.getType():0) == PLUS) ? "\t\tiadd":"\t\tisubt", -1);
            	            }
            	        

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
        return type;
    }
    // $ANTLR end "exp_arithmetic"


    // $ANTLR start "term"
    // Bali.g:157:1: term returns [char type] : l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* ;
    public final char term() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_fact = 0;

        char r_fact = 0;


        try {
            // Bali.g:158:5: (l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* )
            // Bali.g:158:7: l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )*
            {
            pushFollow(FOLLOW_factor_in_term503);
            l_fact=factor();

            state._fsp--;


                    if(l_fact == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:165:7: (op= ( TIMES | OVER | REM ) r_fact= factor )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=TIMES && LA4_0<=REM)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bali.g:165:9: op= ( TIMES | OVER | REM ) r_fact= factor
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

            	    pushFollow(FOLLOW_factor_in_term538);
            	    r_fact=factor();

            	    state._fsp--;


            	            if(l_fact == 's' || r_fact == 's') {
            	                type = 's';
            	            }
            	            else{
            	                type = 'i';

            	                if((op!=null?op.getType():0) == TIMES)
            	                    emit("\t\timul", -1); 
            	                else if((op!=null?op.getType():0) == OVER)
            	                    emit("\t\tidiv", -1);
            	                else
            	                    emit("\t\tirem", -1);
            	            }
            	        

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
        return type;
    }
    // $ANTLR end "term"


    // $ANTLR start "factor"
    // Bali.g:182:1: factor returns [char type] : ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR );
    public final char factor() throws RecognitionException {
        char type = 0;

        Token NUM2=null;
        Token VAR3=null;
        Token STR4=null;
        char exp = 0;


        try {
            // Bali.g:183:5: ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR )
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
                    // Bali.g:183:9: NUM
                    {
                    NUM2=(Token)match(input,NUM,FOLLOW_NUM_in_factor570); 
                     
                                emit("\t\tldc " + (NUM2!=null?NUM2.getText():null), 1);
                                type = 'i';
                            

                    }
                    break;
                case 2 :
                    // Bali.g:187:7: OPEN_P (exp= exp_arithmetic ) CLOSE_P
                    {
                    match(input,OPEN_P,FOLLOW_OPEN_P_in_factor580); 
                    // Bali.g:187:14: (exp= exp_arithmetic )
                    // Bali.g:187:15: exp= exp_arithmetic
                    {
                    pushFollow(FOLLOW_exp_arithmetic_in_factor587);
                    exp=exp_arithmetic();

                    state._fsp--;


                    }

                    match(input,CLOSE_P,FOLLOW_CLOSE_P_in_factor590); 

                                type = exp;
                            

                    }
                    break;
                case 3 :
                    // Bali.g:190:9: VAR
                    {
                    VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_factor602); 

                                int index = findVariable((VAR3!=null?VAR3.getText():null));
                                if(type_table.get(index) == 'i') {
                                    emit("\t\tiload " + index, 1);
                                }
                                else {
                                    emit("\t\taload " + index, 1);
                                }
                                type = type_table.get(index);
                            

                    }
                    break;
                case 4 :
                    // Bali.g:200:9: READINT
                    {
                    match(input,READINT,FOLLOW_READINT_in_factor614); 

                                emit("\tinvokestatic Runtime/readInt()I ;", 1);
                                type = 'i';
                            

                    }
                    break;
                case 5 :
                    // Bali.g:204:9: READSTR
                    {
                    match(input,READSTR,FOLLOW_READSTR_in_factor626); 

                                emit("\tinvokestatic Runtime/readString()Ljava/lang/String;", 1);
                                type = 's';
                            

                    }
                    break;
                case 6 :
                    // Bali.g:208:9: STR
                    {
                    STR4=(Token)match(input,STR,FOLLOW_STR_in_factor638); 

                                emit("\t\tldc " + (STR4!=null?STR4.getText():null), 1);
                            

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
        return type;
    }
    // $ANTLR end "factor"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program299 = new BitSet(new long[]{0x00000000000C1002L});
    public static final BitSet FOLLOW_NL_in_statement328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_attr_in_statement332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_print_in_statement336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_st_attr353 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ATTR_in_st_attr355 = new BitSet(new long[]{0x000000000006E400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_attr362 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NL_in_st_attr365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_st_print393 = new BitSet(new long[]{0x000000000006E400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_print406 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NL_in_st_print414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic439 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_set_in_exp_arithmetic456 = new BitSet(new long[]{0x000000000006E400L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic470 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_factor_in_term503 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_set_in_term521 = new BitSet(new long[]{0x000000000006E400L});
    public static final BitSet FOLLOW_factor_in_term538 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_NUM_in_factor570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_P_in_factor580 = new BitSet(new long[]{0x000000000006E400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_factor587 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_CLOSE_P_in_factor590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_factor602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READINT_in_factor614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READSTR_in_factor626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_factor638 = new BitSet(new long[]{0x0000000000000002L});

}