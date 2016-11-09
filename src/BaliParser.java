// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-11-09 18:01:52

    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTR", "PLUS", "MINUS", "TIMES", "OVER", "REM", "EQ", "NE", "GT", "GE", "LT", "LE", "OPEN_P", "CLOSE_P", "OPEN_C", "CLOSE_C", "IF", "ELSE", "WHILE", "PRINT", "READINT", "READSTR", "PROCEDURE", "NUM", "STR", "VAR", "COMMENT", "NL", "SPACE"
    };
    public static final int PRINT=23;
    public static final int VAR=29;
    public static final int LT=14;
    public static final int READINT=24;
    public static final int READSTR=25;
    public static final int OPEN_P=16;
    public static final int COMMENT=30;
    public static final int MINUS=6;
    public static final int STR=28;
    public static final int SPACE=32;
    public static final int CLOSE_P=17;
    public static final int OPEN_C=18;
    public static final int ELSE=21;
    public static final int EOF=-1;
    public static final int IF=20;
    public static final int GE=13;
    public static final int PROCEDURE=26;
    public static final int TIMES=7;
    public static final int NUM=27;
    public static final int EQ=10;
    public static final int GT=12;
    public static final int CLOSE_C=19;
    public static final int ATTR=4;
    public static final int OVER=8;
    public static final int NE=11;
    public static final int LE=15;
    public static final int WHILE=22;
    public static final int REM=9;
    public static final int NL=31;
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
        
        public static int stack = 0, max_stack = 0, if_counter = 0, while_counter = 0;

        public static void main(String[] args) throws Exception
        {
            ANTLRInputStream input = new ANTLRInputStream(System.in);
            BaliLexer lexer = new BaliLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BaliParser parser = new BaliParser(tokens);

            symbol_table = new ArrayList<String>();
            type_table = new ArrayList<Character>();
            used_table = new ArrayList<Boolean>();

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
    // Bali.g:104:1: program : ( procedure | NL )* ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // Bali.g:105:5: ( ( procedure | NL )* ( statement )+ )
            // Bali.g:105:9: ( procedure | NL )* ( statement )+
            {

                        System.out.println(
                        ".source Test.j\n"+
                        ".class  public Test\n"+
                        ".super  java/lang/Object\n\n");
                    
            // Bali.g:111:9: ( procedure | NL )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NL) ) {
                    alt1=2;
                }
                else if ( (LA1_0==PROCEDURE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bali.g:111:10: procedure
            	    {
            	    pushFollow(FOLLOW_procedure_in_program508);
            	    procedure();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // Bali.g:111:22: NL
            	    {
            	    match(input,NL,FOLLOW_NL_in_program512); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             
                        symbol_table.add("args");
                        type_table.add('S');
                        used_table.add(true);
                        System.out.println(
                        ".method public <init>()V\n"+
                            "\taload_0\n"+
                            "\tinvokenonvirtual java/lang/Object/<init>()V\n"+
                            "\treturn\n"+
                        ".end method\n\n"+
                        ".method public static main([Ljava/lang/String;)V\n\n");
                    
            // Bali.g:124:9: ( statement )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IF||(LA2_0>=WHILE && LA2_0<=PRINT)||LA2_0==VAR||LA2_0==NL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Bali.g:124:10: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program535);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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


    // $ANTLR start "procedure"
    // Bali.g:137:1: procedure : PROCEDURE VAR OPEN_P CLOSE_P OPEN_C NL ( statement )* CLOSE_C NL ;
    public final void procedure() throws RecognitionException {
        Token VAR1=null;

        try {
            // Bali.g:138:5: ( PROCEDURE VAR OPEN_P CLOSE_P OPEN_C NL ( statement )* CLOSE_C NL )
            // Bali.g:139:5: PROCEDURE VAR OPEN_P CLOSE_P OPEN_C NL ( statement )* CLOSE_C NL
            {
            match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure568); 
            VAR1=(Token)match(input,VAR,FOLLOW_VAR_in_procedure570); 
            match(input,OPEN_P,FOLLOW_OPEN_P_in_procedure572); 
            match(input,CLOSE_P,FOLLOW_CLOSE_P_in_procedure574); 
            match(input,OPEN_C,FOLLOW_OPEN_C_in_procedure576); 
            match(input,NL,FOLLOW_NL_in_procedure578); 

                    System.out.println(
                        ".method public static " + (VAR1!=null?VAR1.getText():null) + "()V"
                    );
                
            // Bali.g:144:5: ( statement )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IF||(LA3_0>=WHILE && LA3_0<=PRINT)||LA3_0==VAR||LA3_0==NL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Bali.g:144:6: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_procedure588);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,CLOSE_C,FOLLOW_CLOSE_C_in_procedure592); 

                    System.out.println(
                        "\treturn\n\n"+
                    ".limit stack " + max_stack +"\n"+
                    ".limit locals " + symbol_table.size() + "\n"+
                    ".end method\n");
                        for(int i = 0; i < used_table.size(); i++) {
                            if(!used_table.get(i))
                                System.err.println("warning: Variable '" + symbol_table.get(i) + "' not used");    
                        }
                    stack = max_stack = 0;
                    symbol_table.clear();
                    type_table.clear();
                    used_table.clear();
                
            match(input,NL,FOLLOW_NL_in_procedure600); 

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
    // $ANTLR end "procedure"


    // $ANTLR start "statement"
    // Bali.g:162:1: statement : ( NL | st_attr | st_print | st_while | st_if | st_call );
    public final void statement() throws RecognitionException {
        try {
            // Bali.g:163:5: ( NL | st_attr | st_print | st_while | st_if | st_call )
            int alt4=6;
            switch ( input.LA(1) ) {
            case NL:
                {
                alt4=1;
                }
                break;
            case VAR:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==ATTR) ) {
                    alt4=2;
                }
                else if ( (LA4_2==OPEN_P) ) {
                    alt4=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case PRINT:
                {
                alt4=3;
                }
                break;
            case WHILE:
                {
                alt4=4;
                }
                break;
            case IF:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // Bali.g:163:7: NL
                    {
                    match(input,NL,FOLLOW_NL_in_statement617); 

                    }
                    break;
                case 2 :
                    // Bali.g:163:12: st_attr
                    {
                    pushFollow(FOLLOW_st_attr_in_statement621);
                    st_attr();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // Bali.g:163:22: st_print
                    {
                    pushFollow(FOLLOW_st_print_in_statement625);
                    st_print();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // Bali.g:163:33: st_while
                    {
                    pushFollow(FOLLOW_st_while_in_statement629);
                    st_while();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // Bali.g:163:44: st_if
                    {
                    pushFollow(FOLLOW_st_if_in_statement633);
                    st_if();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // Bali.g:163:52: st_call
                    {
                    pushFollow(FOLLOW_st_call_in_statement637);
                    st_call();

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
    // Bali.g:166:1: st_attr : VAR ATTR (exp= exp_arithmetic ) NL ;
    public final void st_attr() throws RecognitionException {
        Token VAR2=null;
        char exp = 0;


        try {
            // Bali.g:167:5: ( VAR ATTR (exp= exp_arithmetic ) NL )
            // Bali.g:167:7: VAR ATTR (exp= exp_arithmetic ) NL
            {
            VAR2=(Token)match(input,VAR,FOLLOW_VAR_in_st_attr654); 
            match(input,ATTR,FOLLOW_ATTR_in_st_attr656); 
            // Bali.g:167:16: (exp= exp_arithmetic )
            // Bali.g:167:17: exp= exp_arithmetic
            {
            pushFollow(FOLLOW_exp_arithmetic_in_st_attr663);
            exp=exp_arithmetic();

            state._fsp--;


            }

            match(input,NL,FOLLOW_NL_in_st_attr666); 

                    if(exp == 'i'){
                        if(!symbol_table.contains((VAR2!=null?VAR2.getText():null))) {
                            emit("\t\tistore " + createVariable((VAR2!=null?VAR2.getText():null), 'i'), -1);
                        }
                        else {
                            if(type_table.get(findVariable((VAR2!=null?VAR2.getText():null))) != 'i') {
                                System.err.println("error: Variable '" + (VAR2!=null?VAR2.getText():null) + "' is string");
                                System.exit(3);
                            }
                            else {
                                emit("\t\tistore " + createVariable((VAR2!=null?VAR2.getText():null), 'i'), -1);    
                            }
                        }
                    }
                    else{
                        if(!symbol_table.contains((VAR2!=null?VAR2.getText():null))) {
                            emit("\t\tastore " + createVariable((VAR2!=null?VAR2.getText():null), 's'), -1);
                        }
                        else {
                            if(type_table.get(findVariable((VAR2!=null?VAR2.getText():null))) != 's') {
                                System.err.println("error: Variable '" + (VAR2!=null?VAR2.getText():null) + "' is integer");
                                System.exit(3);
                            }
                            else {
                                emit("\t\tastore " + createVariable((VAR2!=null?VAR2.getText():null), 's'), -1);    
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
    // Bali.g:200:1: st_print : PRINT exp= exp_arithmetic NL ;
    public final void st_print() throws RecognitionException {
        char exp = 0;


        try {
            // Bali.g:201:5: ( PRINT exp= exp_arithmetic NL )
            // Bali.g:202:5: PRINT exp= exp_arithmetic NL
            {
            match(input,PRINT,FOLLOW_PRINT_in_st_print694); 
             
                    emit("\tgetstatic java/lang/System/out Ljava/io/PrintStream;", 1); 
                
            pushFollow(FOLLOW_exp_arithmetic_in_st_print707);
            exp=exp_arithmetic();

            state._fsp--;


                    if(exp == 'i')
                        emit("\tinvokevirtual java/io/PrintStream/println(I)V\n", -2);
                    else
                        emit("\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n", -2); 
                
            match(input,NL,FOLLOW_NL_in_st_print715); 

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
    // Bali.g:214:1: st_while : WHILE conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL ;
    public final void st_while() throws RecognitionException {
        String conditional = null;


        try {
            // Bali.g:215:5: ( WHILE conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL )
            // Bali.g:216:5: WHILE conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL
            {
            match(input,WHILE,FOLLOW_WHILE_in_st_while736); 

                    int c = ++while_counter;
                    emit("BEGIN_WHILE_" + c + ":", 0);
                
            pushFollow(FOLLOW_exp_conditional_in_st_while748);
            conditional=exp_conditional();

            state._fsp--;

            match(input,OPEN_C,FOLLOW_OPEN_C_in_st_while750); 
            match(input,NL,FOLLOW_NL_in_st_while752); 

                    emit(conditional + " " + "END_WHILE_" + c + " ;", -2);
                
            // Bali.g:223:5: ( statement )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IF||(LA5_0>=WHILE && LA5_0<=PRINT)||LA5_0==VAR||LA5_0==NL) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Bali.g:223:6: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_st_while762);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,CLOSE_C,FOLLOW_CLOSE_C_in_st_while771); 

                    emit("\t\tgoto BEGIN_WHILE_" + c + " ;", 0);
                    emit("END_WHILE_" + c + ":", 0);
                
            match(input,NL,FOLLOW_NL_in_st_while779); 

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


    // $ANTLR start "st_if"
    // Bali.g:231:1: st_if : IF conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL ( ELSE OPEN_C NL ( statement )* CLOSE_C NL )? ;
    public final void st_if() throws RecognitionException {
        String conditional = null;


        try {
            // Bali.g:232:5: ( IF conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL ( ELSE OPEN_C NL ( statement )* CLOSE_C NL )? )
            // Bali.g:233:5: IF conditional= exp_conditional OPEN_C NL ( statement )* CLOSE_C NL ( ELSE OPEN_C NL ( statement )* CLOSE_C NL )?
            {
            match(input,IF,FOLLOW_IF_in_st_if800); 

                    boolean has_else = false;
                    int c = ++if_counter;
                
            pushFollow(FOLLOW_exp_conditional_in_st_if813);
            conditional=exp_conditional();

            state._fsp--;

            match(input,OPEN_C,FOLLOW_OPEN_C_in_st_if815); 
            match(input,NL,FOLLOW_NL_in_st_if817); 

                    emit(conditional + " " + "NOT_IF_" + c + " ;", -2);
                
            // Bali.g:240:5: ( statement )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IF||(LA6_0>=WHILE && LA6_0<=PRINT)||LA6_0==VAR||LA6_0==NL) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Bali.g:240:6: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_st_if826);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,CLOSE_C,FOLLOW_CLOSE_C_in_st_if830); 
            match(input,NL,FOLLOW_NL_in_st_if837); 
            // Bali.g:242:5: ( ELSE OPEN_C NL ( statement )* CLOSE_C NL )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ELSE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Bali.g:242:7: ELSE OPEN_C NL ( statement )* CLOSE_C NL
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_st_if845); 

                            has_else = true;
                            emit("\t\tgoto END_ELSE_" + c + " ;", 0);
                            emit("NOT_IF_" + c + ":", 0);
                        
                    match(input,OPEN_C,FOLLOW_OPEN_C_in_st_if853); 
                    match(input,NL,FOLLOW_NL_in_st_if855); 
                    // Bali.g:247:15: ( statement )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==IF||(LA7_0>=WHILE && LA7_0<=PRINT)||LA7_0==VAR||LA7_0==NL) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Bali.g:247:16: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_st_if858);
                    	    statement();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match(input,CLOSE_C,FOLLOW_CLOSE_C_in_st_if862); 
                    match(input,NL,FOLLOW_NL_in_st_if864); 

                    }
                    break;

            }


                    emit((has_else?"END_ELSE_":"NOT_IF_") + c + ":", 0);
                

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
    // $ANTLR end "st_if"


    // $ANTLR start "st_call"
    // Bali.g:254:1: st_call : VAR OPEN_P CLOSE_P NL ;
    public final void st_call() throws RecognitionException {
        Token VAR3=null;

        try {
            // Bali.g:255:5: ( VAR OPEN_P CLOSE_P NL )
            // Bali.g:255:7: VAR OPEN_P CLOSE_P NL
            {
            VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_st_call894); 
            match(input,OPEN_P,FOLLOW_OPEN_P_in_st_call896); 
            match(input,CLOSE_P,FOLLOW_CLOSE_P_in_st_call898); 

                    emit("\t\tinvokestatic Test/" + (VAR3!=null?VAR3.getText():null) + "()V", 0);
                
            match(input,NL,FOLLOW_NL_in_st_call906); 

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
    // $ANTLR end "st_call"


    // $ANTLR start "exp_conditional"
    // Bali.g:261:1: exp_conditional returns [String type] : l_exp= exp_arithmetic op= ( EQ | NE | GT | GE | LT | LE ) r_exp= exp_arithmetic ;
    public final String exp_conditional() throws RecognitionException {
        String type = null;

        Token op=null;
        char l_exp = 0;

        char r_exp = 0;


        try {
            // Bali.g:262:5: (l_exp= exp_arithmetic op= ( EQ | NE | GT | GE | LT | LE ) r_exp= exp_arithmetic )
            // Bali.g:263:5: l_exp= exp_arithmetic op= ( EQ | NE | GT | GE | LT | LE ) r_exp= exp_arithmetic
            {
            pushFollow(FOLLOW_exp_arithmetic_in_exp_conditional935);
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

            pushFollow(FOLLOW_exp_arithmetic_in_exp_conditional969);
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
    // Bali.g:289:1: exp_arithmetic returns [char type] : l_term= term (op= ( PLUS | MINUS ) r_term= term )* ;
    public final char exp_arithmetic() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_term = 0;

        char r_term = 0;


        try {
            // Bali.g:290:5: (l_term= term (op= ( PLUS | MINUS ) r_term= term )* )
            // Bali.g:290:7: l_term= term (op= ( PLUS | MINUS ) r_term= term )*
            {
            pushFollow(FOLLOW_term_in_exp_arithmetic996);
            l_term=term();

            state._fsp--;


                    if(l_term == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:296:7: (op= ( PLUS | MINUS ) r_term= term )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=PLUS && LA9_0<=MINUS)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Bali.g:296:9: op= ( PLUS | MINUS ) r_term= term
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

            	    pushFollow(FOLLOW_term_in_exp_arithmetic1027);
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
            	    break loop9;
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
    // Bali.g:308:1: term returns [char type] : l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* ;
    public final char term() throws RecognitionException {
        char type = 0;

        Token op=null;
        char l_fact = 0;

        char r_fact = 0;


        try {
            // Bali.g:309:5: (l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )* )
            // Bali.g:309:7: l_fact= factor (op= ( TIMES | OVER | REM ) r_fact= factor )*
            {
            pushFollow(FOLLOW_factor_in_term1060);
            l_fact=factor();

            state._fsp--;


                    if(l_fact == 'i')
                        type = 'i';
                    else
                        type = 's';
                  
            // Bali.g:316:7: (op= ( TIMES | OVER | REM ) r_fact= factor )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=TIMES && LA10_0<=REM)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Bali.g:316:9: op= ( TIMES | OVER | REM ) r_fact= factor
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

            	    pushFollow(FOLLOW_factor_in_term1095);
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
            	    break loop10;
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
    // Bali.g:334:1: factor returns [char type] : ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR );
    public final char factor() throws RecognitionException {
        char type = 0;

        Token NUM4=null;
        Token VAR5=null;
        Token STR6=null;
        char exp = 0;


        try {
            // Bali.g:335:5: ( NUM | OPEN_P (exp= exp_arithmetic ) CLOSE_P | VAR | READINT | READSTR | STR )
            int alt11=6;
            switch ( input.LA(1) ) {
            case NUM:
                {
                alt11=1;
                }
                break;
            case OPEN_P:
                {
                alt11=2;
                }
                break;
            case VAR:
                {
                alt11=3;
                }
                break;
            case READINT:
                {
                alt11=4;
                }
                break;
            case READSTR:
                {
                alt11=5;
                }
                break;
            case STR:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // Bali.g:335:9: NUM
                    {
                    NUM4=(Token)match(input,NUM,FOLLOW_NUM_in_factor1127); 
                     
                                emit("\t\tldc " + (NUM4!=null?NUM4.getText():null), 1);
                                type = 'i';
                            

                    }
                    break;
                case 2 :
                    // Bali.g:339:7: OPEN_P (exp= exp_arithmetic ) CLOSE_P
                    {
                    match(input,OPEN_P,FOLLOW_OPEN_P_in_factor1137); 
                    // Bali.g:339:14: (exp= exp_arithmetic )
                    // Bali.g:339:15: exp= exp_arithmetic
                    {
                    pushFollow(FOLLOW_exp_arithmetic_in_factor1144);
                    exp=exp_arithmetic();

                    state._fsp--;


                    }

                    match(input,CLOSE_P,FOLLOW_CLOSE_P_in_factor1147); 

                                type = exp;
                            

                    }
                    break;
                case 3 :
                    // Bali.g:342:9: VAR
                    {
                    VAR5=(Token)match(input,VAR,FOLLOW_VAR_in_factor1159); 

                                int index = findVariable((VAR5!=null?VAR5.getText():null));
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
                    // Bali.g:352:9: READINT
                    {
                    match(input,READINT,FOLLOW_READINT_in_factor1171); 

                                emit("\tinvokestatic Runtime/readInt()I ;", 1);
                                type = 'i';
                            

                    }
                    break;
                case 5 :
                    // Bali.g:356:9: READSTR
                    {
                    match(input,READSTR,FOLLOW_READSTR_in_factor1183); 

                                emit("\tinvokestatic Runtime/readString()Ljava/lang/String;", 1);
                                type = 's';
                            

                    }
                    break;
                case 6 :
                    // Bali.g:360:9: STR
                    {
                    STR6=(Token)match(input,STR,FOLLOW_STR_in_factor1195); 

                                emit("\t\tldc " + (STR6!=null?STR6.getText():null), 1);
                            

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


 

    public static final BitSet FOLLOW_procedure_in_program508 = new BitSet(new long[]{0x00000000A4D00000L});
    public static final BitSet FOLLOW_NL_in_program512 = new BitSet(new long[]{0x00000000A4D00000L});
    public static final BitSet FOLLOW_statement_in_program535 = new BitSet(new long[]{0x00000000A0D00002L});
    public static final BitSet FOLLOW_PROCEDURE_in_procedure568 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_VAR_in_procedure570 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_OPEN_P_in_procedure572 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_P_in_procedure574 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_OPEN_C_in_procedure576 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_procedure578 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_statement_in_procedure588 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_CLOSE_C_in_procedure592 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_procedure600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NL_in_statement617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_attr_in_statement621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_print_in_statement625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_while_in_statement629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_if_in_statement633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_st_call_in_statement637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_st_attr654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ATTR_in_st_attr656 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_attr663 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_attr666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_st_print694 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_st_print707 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_print715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_st_while736 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_exp_conditional_in_st_while748 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_OPEN_C_in_st_while750 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_while752 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_statement_in_st_while762 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_CLOSE_C_in_st_while771 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_while779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_st_if800 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_exp_conditional_in_st_if813 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_OPEN_C_in_st_if815 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_if817 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_statement_in_st_if826 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_CLOSE_C_in_st_if830 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_if837 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ELSE_in_st_if845 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_OPEN_C_in_st_if853 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_if855 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_statement_in_st_if858 = new BitSet(new long[]{0x00000000A0D80000L});
    public static final BitSet FOLLOW_CLOSE_C_in_st_if862 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_if864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_st_call894 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_OPEN_P_in_st_call896 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_P_in_st_call898 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NL_in_st_call906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exp_arithmetic_in_exp_conditional935 = new BitSet(new long[]{0x000000000000FC00L});
    public static final BitSet FOLLOW_set_in_exp_conditional941 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_exp_conditional969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic996 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_set_in_exp_arithmetic1013 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_term_in_exp_arithmetic1027 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_factor_in_term1060 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_set_in_term1078 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_factor_in_term1095 = new BitSet(new long[]{0x0000000000000382L});
    public static final BitSet FOLLOW_NUM_in_factor1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_P_in_factor1137 = new BitSet(new long[]{0x000000003B010000L});
    public static final BitSet FOLLOW_exp_arithmetic_in_factor1144 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_P_in_factor1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_factor1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READINT_in_factor1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READSTR_in_factor1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_factor1195 = new BitSet(new long[]{0x0000000000000002L});

}