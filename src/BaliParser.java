// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-10-05 17:51:16

    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTR", "PLUS", "MINUS", "TIMES", "OVER", "REM", "OPEN_P", "CLOSE_P", "PRINT", "READINT", "READSTR", "NUM", "STR", "VAR", "COMMENT", "NL", "SPACE"
    };
    public static final int PRINT=12;
    public static final int VAR=17;
    public static final int READINT=13;
    public static final int READSTR=14;
    public static final int OPEN_P=10;
    public static final int COMMENT=18;
    public static final int MINUS=6;
    public static final int STR=16;
    public static final int SPACE=20;
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
        private static ArrayList<Boolean> used_table;
        
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



    // $ANTLR start "program"
    // Bali.g:92:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // Bali.g:93:5: ( ( statement )+ )
            // Bali.g:93:9: ( statement )+
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
                    
            // Bali.g:105:9: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PRINT||LA1_0==VAR||LA1_0==NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bali.g:105:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program314);
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
                        for(int i = 0; i < used_table.size(); i++) {
                            if(!used_table.get(i))
                                System.err.println("warning: Variable '" + symbol_table.get(i) + "' not used");    
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
    // $ANTLR end "program"


    // $ANTLR start "statement"
    // Bali.g:118:1: statement : ( NL | st_attr | st_print );
    public final void statement() throws RecognitionException {
        try {
            // Bali.g:119:5: ( NL | st_attr | st_print )
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
                    // Bali.g:119:7: NL
                    {
                    match(input,NL,FOLLOW_NL_in_statement343); 

                    }
                    break;
                case 2 :
                    // Bali.g:119:12: st_attr
                    {
                    pushFollow(FOLLOW_st_attr_in_statement347);
                    st_attr();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // Bali.g:119:22: st_print
                    {
                    pushFollow(FOLLOW_st_print_in_statement351);
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
    // Bali.g:122:1: st_attr : VAR ATTR (exp= exp_arithmetic ) NL ;
    public final void st_attr() throws RecognitionException {
        Token VAR1=null;
        char exp = 0;


        try {
            // Bali.g:123:5: ( VAR ATTR (exp= exp_arithmetic ) NL )
            // Bali.g:123:7: VAR ATTR (exp= exp_arithmetic ) NL
            {
            VAR1=(Token)match(input,VAR,FOLLOW_VAR_in_st_attr368); 
            match(input,ATTR,FOLLOW_ATTR_in_st_attr370); 
            // Bali.g:123:16: (exp= exp_arithmetic )
            // Bali.g:123:17: exp= exp_arithmetic
            {
            pushFollow(FOLLOW_exp_arithmetic_in_st_attr377);
            exp=exp_arithmetic();

            state._fsp--;


            }

            match(input,NL,FOLLOW_NL_in_st_attr380); 

                    if(exp == 'i'){
                        if(!symbol_table.contains((VAR1!=null?VAR1.getText():null))) {
                            emit("\t\tistore " + createVariable((VAR1!=null?VAR1.getText():null), 'i'), -1);
                        }
                        else {
                            if(type_table.get(findVariable((VAR1!=null?VAR1.getText():null))) != 'i') {
                                System.err.println("error: Variable '" + (VAR1!=null?VAR1.getText():null) + "' is string");
                                System.exit(3);
                            }
                            else {
                                emit("\t\tistore " + createVariable((VAR1!=null?VAR1.getText():null), 'i'), -1);    
                            }
                        }
                    }
                    else{
                        if(!symbol_table.contains((VAR1!=null?VAR1.getText():null))) {
                            emit("\t\tastore " + createVariable((VAR1!=null?VAR1.getText():null), 's'), -1);
                        }
                        else {
                            if(type_table.get(findVariable((VAR1!=null?VAR1.getText():null))) != 's') {
                                System.err.println("error: Variable '" + (VAR1!=null?VAR1.getText():null) + "' is integer");
                                System.exit(3);
                            }
                            else {
                                emit("\t\tastore " + createVariable((VAR1!=null?VAR1.getText():null), 's'), -1);    
                            }
                        }
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
    // Bali.g:156:1: st_print : PRINT exp= exp_arithmetic NL ;
    public final void st_print() throws RecognitionException {
        char exp = 0;


        try {
            // Bali.g:157:5: ( PRINT exp= exp_arithmetic NL )
            // Bali.g:158:5: PRINT exp= exp_arithmetic NL
            {
            match(input,PRINT,FOLLOW_PRINT_in_st_print408); 
             
                    emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); 
                
            pushFollow(FOLLOW_exp_arithmetic_in_st_print421);
            exp=exp_arithmetic();

            state._fsp--;


                    if(exp == 'i')
                        emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2);
                    else
                        emit("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n", -2); 
                
            match(input,NL,FOLLOW_NL_in_st_print429); 

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
    // Bali.g:170:1: exp_arithmetic returns [char type] : l_term= term (op= ( PLUS | MINUS ) r_term= term )* ;
    public final char exp_arithmetic() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_term = 0;

        char r_term = 0;


        try {
            // Bali.g:171:5: (l_term= term (op= ( PLUS | MINUS ) r_term= term )* )
            // Bali.g:171:7: l_term= term (op= ( PLUS | MINUS ) r_term= term )*
            {
            pushFollow(FOLLOW_term_in_exp_arithmetic454);
            l_term=term();

            state._fsp--;


                    if(l_term == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:177:7: (op= ( PLUS | MINUS ) r_term= term )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=PLUS && LA3_0<=MINUS)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bali.g:177:9: op= ( PLUS | MINUS ) r_term= term
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

            	    pushFollow(FOLLOW_term_in_exp_arithmetic485);
            	    r_term=term();

            	    state._fsp--;


            	            if(l_term == 's' || r_term == 's') {
            	                System.err.println("Can't apply operator on string!");
            	                System.exit(3);
            	            }
            	            else{
            	                type = 'i';
            	                emit(((op!=null?op.getType():0) == PLUS) ? "\t\tiadd":"\t\tisub", -1);
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
    // Bali.g:189:1: term returns [char type] : l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* ;
    public final char term() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_fact = 0;

        char r_fact = 0;


        try {
            // Bali.g:190:5: (l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* )
            // Bali.g:190:7: l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )*
            {
            pushFollow(FOLLOW_factor_in_term518);
            l_fact=factor();

            state._fsp--;


                    if(l_fact == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:197:7: (op= ( TIMES | OVER | REM ) r_fact= factor )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=TIMES && LA4_0<=REM)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bali.g:197:9: op= ( TIMES | OVER | REM ) r_fact= factor
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

            	    pushFollow(FOLLOW_factor_in_term553);
            	    r_fact=factor();

            	    state._fsp--;


            	            if(l_fact == 's' || r_fact == 's') {
            	                System.err.println("Can't apply operator on string!");
            	                System.exit(3);
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
    // Bali.g:215:1: factor returns [char type] : ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR );
    public final char factor() throws RecognitionException {
        char type = 0;

        Token NUM2=null;
        Token VAR3=null;
        Token STR4=null;
        char exp = 0;


        try {
            // Bali.g:216:5: ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR )
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
                    // Bali.g:216:9: NUM
                    {
                    NUM2=(Token)match(input,NUM,FOLLOW_NUM_in_factor585); 
                     
                                emit("\t\tldc " + (NUM2!=null?NUM2.getText():null), 1);
                                type = 'i';
                            

                    }
                    break;
                case 2 :
                    // Bali.g:220:7: OPEN_P (exp= exp_arithmetic ) CLOSE_P
                    {
                    match(input,OPEN_P,FOLLOW_OPEN_P_in_factor595); 
                    // Bali.g:220:14: (exp= exp_arithmetic )
                    // Bali.g:220:15: exp= exp_arithmetic
                    {
                    pushFollow(FOLLOW_exp_arithmetic_in_factor602);
                    exp=exp_arithmetic();

                    state._fsp--;


                    }

                    match(input,CLOSE_P,FOLLOW_CLOSE_P_in_factor605); 

                                type = exp;
                            

                    }
                    break;
                case 3 :
                    // Bali.g:223:9: VAR
                    {
                    VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_factor617); 

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
                    // Bali.g:233:9: READINT
                    {
                    match(input,READINT,FOLLOW_READINT_in_factor629); 

                                emit("\tinvokestatic Runtime/readInt()I ;", 1);
                                type = 'i';
                            

                    }
                    break;
                case 5 :
                    // Bali.g:237:9: READSTR
                    {
                    match(input,READSTR,FOLLOW_READSTR_in_factor641); 

                                emit("\tinvokestatic Runtime/readString()Ljava/lang/String;", 1);
                                type = 's';
                            

                    }
                    break;
                case 6 :
                    // Bali.g:241:9: STR
                    {
                    STR4=(Token)match(input,STR,FOLLOW_STR_in_factor653); 

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


 

    public static final BitSet FOLLOW_statement_in_program314 = new BitSet(new long[]{0x00000000000A1002L});
    public static final BitSet FOLLOW_NL_in_statement343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_attr_in_statement347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_print_in_statement351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_st_attr368 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ATTR_in_st_attr370 = new BitSet(new long[]{0x000000000003E400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_attr377 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NL_in_st_attr380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_st_print408 = new BitSet(new long[]{0x000000000003E400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_print421 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NL_in_st_print429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic454 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_set_in_exp_arithmetic471 = new BitSet(new long[]{0x000000000003E400L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic485 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_factor_in_term518 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_set_in_term536 = new BitSet(new long[]{0x000000000003E400L});
    public static final BitSet FOLLOW_factor_in_term553 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_NUM_in_factor585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_P_in_factor595 = new BitSet(new long[]{0x000000000003E400L});
    public static final BitSet FOLLOW_exp_arithmetic_in_factor602 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_CLOSE_P_in_factor605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_factor617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READINT_in_factor629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READSTR_in_factor641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_factor653 = new BitSet(new long[]{0x0000000000000002L});

}