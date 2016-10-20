// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-10-20 15:04:43

    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTR", "PLUS", "MINUS", "TIMES", "OVER", "REM", "EQ", "NE", "GT", "GE", "LT", "LE", "OPEN_P", "CLOSE_P", "OPEN_C", "CLOSE_C", "WHILE", "PRINT", "READINT", "READSTR", "NUM", "STR", "VAR", "COMMENT", "NL", "SPACE"
    };
    public static final int PRINT=21;
    public static final int VAR=26;
    public static final int LT=14;
    public static final int READINT=22;
    public static final int READSTR=23;
    public static final int OPEN_P=16;
    public static final int COMMENT=27;
    public static final int MINUS=6;
    public static final int STR=25;
    public static final int SPACE=29;
    public static final int CLOSE_P=17;
    public static final int OPEN_C=18;
    public static final int EOF=-1;
    public static final int GE=13;
    public static final int TIMES=7;
    public static final int NUM=24;
    public static final int EQ=10;
    public static final int GT=12;
    public static final int CLOSE_C=19;
    public static final int ATTR=4;
    public static final int OVER=8;
    public static final int NE=11;
    public static final int LE=15;
    public static final int WHILE=20;
    public static final int REM=9;
    public static final int NL=28;
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
        
        public static int stack = 0, max_stack = 0, while_counter = 0;

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
    // Bali.g:101:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // Bali.g:102:5: ( ( statement )+ )
            // Bali.g:102:9: ( statement )+
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
                    
            // Bali.g:114:9: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=WHILE && LA1_0<=PRINT)||LA1_0==VAR||LA1_0==NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bali.g:114:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program450);
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
    // Bali.g:127:1: statement : ( NL | st_attr | st_print | st_while );
    public final void statement() throws RecognitionException {
        try {
            // Bali.g:128:5: ( NL | st_attr | st_print | st_while )
            int alt2=4;
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
            case WHILE:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // Bali.g:128:7: NL
                    {
                    match(input,NL,FOLLOW_NL_in_statement479); 

                    }
                    break;
                case 2 :
                    // Bali.g:128:12: st_attr
                    {
                    pushFollow(FOLLOW_st_attr_in_statement483);
                    st_attr();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // Bali.g:128:22: st_print
                    {
                    pushFollow(FOLLOW_st_print_in_statement487);
                    st_print();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // Bali.g:128:33: st_while
                    {
                    pushFollow(FOLLOW_st_while_in_statement491);
                    st_while();

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
    // Bali.g:131:1: st_attr : VAR ATTR (exp= exp_arithmetic ) NL ;
    public final void st_attr() throws RecognitionException {
        Token VAR1=null;
        char exp = 0;


        try {
            // Bali.g:132:5: ( VAR ATTR (exp= exp_arithmetic ) NL )
            // Bali.g:132:7: VAR ATTR (exp= exp_arithmetic ) NL
            {
            VAR1=(Token)match(input,VAR,FOLLOW_VAR_in_st_attr508); 
            match(input,ATTR,FOLLOW_ATTR_in_st_attr510); 
            // Bali.g:132:16: (exp= exp_arithmetic )
            // Bali.g:132:17: exp= exp_arithmetic
            {
            pushFollow(FOLLOW_exp_arithmetic_in_st_attr517);
            exp=exp_arithmetic();

            state._fsp--;


            }

            match(input,NL,FOLLOW_NL_in_st_attr520); 

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
    // Bali.g:165:1: st_print : PRINT exp= exp_arithmetic NL ;
    public final void st_print() throws RecognitionException {
        char exp = 0;


        try {
            // Bali.g:166:5: ( PRINT exp= exp_arithmetic NL )
            // Bali.g:167:5: PRINT exp= exp_arithmetic NL
            {
            match(input,PRINT,FOLLOW_PRINT_in_st_print548); 
             
                    emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); 
                
            pushFollow(FOLLOW_exp_arithmetic_in_st_print561);
            exp=exp_arithmetic();

            state._fsp--;


                    if(exp == 'i')
                        emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2);
                    else
                        emit("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n", -2); 
                
            match(input,NL,FOLLOW_NL_in_st_print569); 

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


    // $ANTLR start "st_while"
    // Bali.g:179:1: st_while : WHILE conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL ;
    public final void st_while() throws RecognitionException {
        String conditional = null;


        try {
            // Bali.g:180:5: ( WHILE conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL )
            // Bali.g:181:5: WHILE conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL
            {
            match(input,WHILE,FOLLOW_WHILE_in_st_while590); 

                    emit("BEGIN_WHILE_" + ++while_counter + ":", 0);
                
            pushFollow(FOLLOW_exp_conditional_in_st_while602);
            conditional=exp_conditional();

            state._fsp--;

            match(input,OPEN_C,FOLLOW_OPEN_C_in_st_while604); 
            match(input,NL,FOLLOW_NL_in_st_while606); 

                    //System.err.println(conditional)
                    emit(conditional + " " + "END_WHILE_" + while_counter + " ;", -2);
                
            // Bali.g:188:5: ( statement )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=WHILE && LA3_0<=PRINT)||LA3_0==VAR||LA3_0==NL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bali.g:188:6: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_st_while616);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,CLOSE_C,FOLLOW_CLOSE_C_in_st_while625); 

                    emit("\t\tgoto BEGIN_WHILE_" + while_counter + " ;", 0);
                    emit("END_WHILE_" + while_counter + ":", 0);
                
            match(input,NL,FOLLOW_NL_in_st_while633); 

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
    // $ANTLR end "st_while"


    // $ANTLR start "exp_conditional"
    // Bali.g:196:1: exp_conditional returns [String type] : l_exp= exp_arithmetic op= ( EQ | NE | GT | GE | LT | LE ) r_exp= exp_arithmetic ;
    public final String exp_conditional() throws RecognitionException {
        String type = null;

        Token op=null;
        char l_exp = 0;

        char r_exp = 0;


        try {
            // Bali.g:197:5: (l_exp= exp_arithmetic op= ( EQ | NE | GT | GE | LT | LE ) r_exp= exp_arithmetic )
            // Bali.g:198:5: l_exp= exp_arithmetic op= ( EQ | NE | GT | GE | LT | LE ) r_exp= exp_arithmetic
            {
            pushFollow(FOLLOW_exp_arithmetic_in_exp_conditional662);
            l_exp=exp_arithmetic();

            state._fsp--;

            op=(Token)input.LT(1);
            if ( (input.LA(1)>=EQ && input.LA(1)<=LE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_exp_arithmetic_in_exp_conditional696);
            r_exp=exp_arithmetic();

            state._fsp--;


                    if(l_exp != 'i' || r_exp != 'i'){
                        System.err.println("Can't apply operator on string!");
                        System.exit(3);
                    }
                    if((op!=null?op.getType():0) == EQ){
                        type = "if_icmpne";
                    }
                    else if((op!=null?op.getType():0) == NE) {
                        type = "if_icmpeq";
                    }
                    else if((op!=null?op.getType():0) == GT) {
                        type = "if_icmple";
                    }
                    else if((op!=null?op.getType():0) == GE) {
                        type = "if_icmplt";
                    }
                    else if((op!=null?op.getType():0) == LT) {
                        type = "if_icmpge";
                    }
                    else if((op!=null?op.getType():0) == LE) {
                        type = "if_icmpgt";
                    }
                

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
    // $ANTLR end "exp_conditional"


    // $ANTLR start "exp_arithmetic"
    // Bali.g:224:1: exp_arithmetic returns [char type] : l_term= term (op= ( PLUS | MINUS ) r_term= term )* ;
    public final char exp_arithmetic() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_term = 0;

        char r_term = 0;


        try {
            // Bali.g:225:5: (l_term= term (op= ( PLUS | MINUS ) r_term= term )* )
            // Bali.g:225:7: l_term= term (op= ( PLUS | MINUS ) r_term= term )*
            {
            pushFollow(FOLLOW_term_in_exp_arithmetic723);
            l_term=term();

            state._fsp--;


                    if(l_term == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:231:7: (op= ( PLUS | MINUS ) r_term= term )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=PLUS && LA4_0<=MINUS)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bali.g:231:9: op= ( PLUS | MINUS ) r_term= term
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

            	    pushFollow(FOLLOW_term_in_exp_arithmetic754);
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
    // $ANTLR end "exp_arithmetic"


    // $ANTLR start "term"
    // Bali.g:243:1: term returns [char type] : l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* ;
    public final char term() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_fact = 0;

        char r_fact = 0;


        try {
            // Bali.g:244:5: (l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* )
            // Bali.g:244:7: l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )*
            {
            pushFollow(FOLLOW_factor_in_term787);
            l_fact=factor();

            state._fsp--;


                    if(l_fact == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:251:7: (op= ( TIMES | OVER | REM ) r_fact= factor )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=TIMES && LA5_0<=REM)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Bali.g:251:9: op= ( TIMES | OVER | REM ) r_fact= factor
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

            	    pushFollow(FOLLOW_factor_in_term822);
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
            	    break loop5;
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
    // Bali.g:269:1: factor returns [char type] : ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR );
    public final char factor() throws RecognitionException {
        char type = 0;

        Token NUM2=null;
        Token VAR3=null;
        Token STR4=null;
        char exp = 0;


        try {
            // Bali.g:270:5: ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR )
            int alt6=6;
            switch ( input.LA(1) ) {
            case NUM:
                {
                alt6=1;
                }
                break;
            case OPEN_P:
                {
                alt6=2;
                }
                break;
            case VAR:
                {
                alt6=3;
                }
                break;
            case READINT:
                {
                alt6=4;
                }
                break;
            case READSTR:
                {
                alt6=5;
                }
                break;
            case STR:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // Bali.g:270:9: NUM
                    {
                    NUM2=(Token)match(input,NUM,FOLLOW_NUM_in_factor854); 
                     
                                emit("\t\tldc " + (NUM2!=null?NUM2.getText():null), 1);
                                type = 'i';
                            

                    }
                    break;
                case 2 :
                    // Bali.g:274:7: OPEN_P (exp= exp_arithmetic ) CLOSE_P
                    {
                    match(input,OPEN_P,FOLLOW_OPEN_P_in_factor864); 
                    // Bali.g:274:14: (exp= exp_arithmetic )
                    // Bali.g:274:15: exp= exp_arithmetic
                    {
                    pushFollow(FOLLOW_exp_arithmetic_in_factor871);
                    exp=exp_arithmetic();

                    state._fsp--;


                    }

                    match(input,CLOSE_P,FOLLOW_CLOSE_P_in_factor874); 

                                type = exp;
                            

                    }
                    break;
                case 3 :
                    // Bali.g:277:9: VAR
                    {
                    VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_factor886); 

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
                    // Bali.g:287:9: READINT
                    {
                    match(input,READINT,FOLLOW_READINT_in_factor898); 

                                emit("\tinvokestatic Runtime/readInt()I ;", 1);
                                type = 'i';
                            

                    }
                    break;
                case 5 :
                    // Bali.g:291:9: READSTR
                    {
                    match(input,READSTR,FOLLOW_READSTR_in_factor910); 

                                emit("\tinvokestatic Runtime/readString()Ljava/lang/String;", 1);
                                type = 's';
                            

                    }
                    break;
                case 6 :
                    // Bali.g:295:9: STR
                    {
                    STR4=(Token)match(input,STR,FOLLOW_STR_in_factor922); 

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


 

    public static final BitSet FOLLOW_statement_in_program450 = new BitSet(new long[]{0x0000000014300002L});
    public static final BitSet FOLLOW_NL_in_statement479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_attr_in_statement483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_print_in_statement487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_while_in_statement491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_st_attr508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ATTR_in_st_attr510 = new BitSet(new long[]{0x0000000007C10000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_attr517 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_NL_in_st_attr520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_st_print548 = new BitSet(new long[]{0x0000000007C10000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_print561 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_NL_in_st_print569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_st_while590 = new BitSet(new long[]{0x0000000007C10000L});
    public static final BitSet FOLLOW_exp_conditional_in_st_while602 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_OPEN_C_in_st_while604 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_NL_in_st_while606 = new BitSet(new long[]{0x0000000014380000L});
    public static final BitSet FOLLOW_statement_in_st_while616 = new BitSet(new long[]{0x0000000014380000L});
    public static final BitSet FOLLOW_CLOSE_C_in_st_while625 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_NL_in_st_while633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exp_arithmetic_in_exp_conditional662 = new BitSet(new long[]{0x000000000000FC00L});
    public static final BitSet FOLLOW_set_in_exp_conditional668 = new BitSet(new long[]{0x0000000007C10000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_exp_conditional696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic723 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_set_in_exp_arithmetic740 = new BitSet(new long[]{0x0000000007C10000L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic754 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_factor_in_term787 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_set_in_term805 = new BitSet(new long[]{0x0000000007C10000L});
    public static final BitSet FOLLOW_factor_in_term822 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_NUM_in_factor854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_P_in_factor864 = new BitSet(new long[]{0x0000000007C10000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_factor871 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_P_in_factor874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_factor886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READINT_in_factor898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READSTR_in_factor910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_factor922 = new BitSet(new long[]{0x0000000000000002L});

}