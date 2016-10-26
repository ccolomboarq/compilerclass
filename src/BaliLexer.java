// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-10-26 17:48:27

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliLexer extends Lexer {
    public static final int PRINT=23;
    public static final int VAR=28;
    public static final int LT=14;
    public static final int READINT=24;
    public static final int READSTR=25;
    public static final int OPEN_P=16;
    public static final int COMMENT=29;
    public static final int MINUS=6;
    public static final int STR=27;
    public static final int SPACE=31;
    public static final int CLOSE_P=17;
    public static final int OPEN_C=18;
    public static final int ELSE=21;
    public static final int EOF=-1;
    public static final int IF=20;
    public static final int GE=13;
    public static final int TIMES=7;
    public static final int NUM=26;
    public static final int EQ=10;
    public static final int GT=12;
    public static final int CLOSE_C=19;
    public static final int ATTR=4;
    public static final int OVER=8;
    public static final int NE=11;
    public static final int LE=15;
    public static final int WHILE=22;
    public static final int REM=9;
    public static final int NL=30;
    public static final int PLUS=5;

    // delegates
    // delegators

    public BaliLexer() {;} 
    public BaliLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BaliLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Bali.g"; }

    // $ANTLR start "ATTR"
    public final void mATTR() throws RecognitionException {
        try {
            int _type = ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:3:6: ( '=' )
            // Bali.g:3:8: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATTR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:4:6: ( '+' )
            // Bali.g:4:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:5:7: ( '-' )
            // Bali.g:5:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "TIMES"
    public final void mTIMES() throws RecognitionException {
        try {
            int _type = TIMES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:6:7: ( '*' )
            // Bali.g:6:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TIMES"

    // $ANTLR start "OVER"
    public final void mOVER() throws RecognitionException {
        try {
            int _type = OVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:7:6: ( '/' )
            // Bali.g:7:8: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OVER"

    // $ANTLR start "REM"
    public final void mREM() throws RecognitionException {
        try {
            int _type = REM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:8:5: ( '%' )
            // Bali.g:8:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REM"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:9:4: ( '==' )
            // Bali.g:9:6: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:10:4: ( '!=' )
            // Bali.g:10:6: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:11:4: ( '>' )
            // Bali.g:11:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:12:4: ( '>=' )
            // Bali.g:12:6: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:13:4: ( '<' )
            // Bali.g:13:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:14:4: ( '<=' )
            // Bali.g:14:6: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "OPEN_P"
    public final void mOPEN_P() throws RecognitionException {
        try {
            int _type = OPEN_P;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:15:8: ( '(' )
            // Bali.g:15:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_P"

    // $ANTLR start "CLOSE_P"
    public final void mCLOSE_P() throws RecognitionException {
        try {
            int _type = CLOSE_P;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:16:9: ( ')' )
            // Bali.g:16:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_P"

    // $ANTLR start "OPEN_C"
    public final void mOPEN_C() throws RecognitionException {
        try {
            int _type = OPEN_C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:17:8: ( '{' )
            // Bali.g:17:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_C"

    // $ANTLR start "CLOSE_C"
    public final void mCLOSE_C() throws RecognitionException {
        try {
            int _type = CLOSE_C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:18:9: ( '}' )
            // Bali.g:18:11: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_C"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:19:4: ( 'if' )
            // Bali.g:19:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:20:6: ( 'else' )
            // Bali.g:20:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:21:7: ( 'while' )
            // Bali.g:21:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "PRINT"
    public final void mPRINT() throws RecognitionException {
        try {
            int _type = PRINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:22:7: ( 'print' )
            // Bali.g:22:9: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINT"

    // $ANTLR start "READINT"
    public final void mREADINT() throws RecognitionException {
        try {
            int _type = READINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:23:9: ( 'read_int' )
            // Bali.g:23:11: 'read_int'
            {
            match("read_int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READINT"

    // $ANTLR start "READSTR"
    public final void mREADSTR() throws RecognitionException {
        try {
            int _type = READSTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:24:9: ( 'read_str' )
            // Bali.g:24:11: 'read_str'
            {
            match("read_str"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READSTR"

    // $ANTLR start "NUM"
    public final void mNUM() throws RecognitionException {
        try {
            int _type = NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:93:9: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // Bali.g:93:11: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // Bali.g:93:11: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Bali.g:93:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            // Bali.g:93:20: ( '.' ( '0' .. '9' )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Bali.g:93:21: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // Bali.g:93:25: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Bali.g:93:25: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUM"

    // $ANTLR start "STR"
    public final void mSTR() throws RecognitionException {
        try {
            int _type = STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:94:9: ( '\"' (~ ( '\"' ) )* '\"' )
            // Bali.g:94:11: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            // Bali.g:94:14: (~ ( '\"' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Bali.g:94:14: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STR"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:95:9: ( ( 'a' .. 'z' )+ )
            // Bali.g:95:11: ( 'a' .. 'z' )+
            {
            // Bali.g:95:11: ( 'a' .. 'z' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Bali.g:95:11: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:96:9: ( '#' (~ ( '\\n' ) )* )
            // Bali.g:96:11: '#' (~ ( '\\n' ) )*
            {
            match('#'); 
            // Bali.g:96:15: (~ ( '\\n' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Bali.g:96:15: ~ ( '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:97:9: ( ( '\\r' )? '\\n' )
            // Bali.g:97:11: ( '\\r' )? '\\n'
            {
            // Bali.g:97:11: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Bali.g:97:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NL"

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:98:9: ( ( ' ' | '\\t' )+ )
            // Bali.g:98:11: ( ' ' | '\\t' )+
            {
            // Bali.g:98:11: ( ' ' | '\\t' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Bali.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SPACE"

    public void mTokens() throws RecognitionException {
        // Bali.g:1:8: ( ATTR | PLUS | MINUS | TIMES | OVER | REM | EQ | NE | GT | GE | LT | LE | OPEN_P | CLOSE_P | OPEN_C | CLOSE_C | IF | ELSE | WHILE | PRINT | READINT | READSTR | NUM | STR | VAR | COMMENT | NL | SPACE )
        int alt9=28;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // Bali.g:1:10: ATTR
                {
                mATTR(); 

                }
                break;
            case 2 :
                // Bali.g:1:15: PLUS
                {
                mPLUS(); 

                }
                break;
            case 3 :
                // Bali.g:1:20: MINUS
                {
                mMINUS(); 

                }
                break;
            case 4 :
                // Bali.g:1:26: TIMES
                {
                mTIMES(); 

                }
                break;
            case 5 :
                // Bali.g:1:32: OVER
                {
                mOVER(); 

                }
                break;
            case 6 :
                // Bali.g:1:37: REM
                {
                mREM(); 

                }
                break;
            case 7 :
                // Bali.g:1:41: EQ
                {
                mEQ(); 

                }
                break;
            case 8 :
                // Bali.g:1:44: NE
                {
                mNE(); 

                }
                break;
            case 9 :
                // Bali.g:1:47: GT
                {
                mGT(); 

                }
                break;
            case 10 :
                // Bali.g:1:50: GE
                {
                mGE(); 

                }
                break;
            case 11 :
                // Bali.g:1:53: LT
                {
                mLT(); 

                }
                break;
            case 12 :
                // Bali.g:1:56: LE
                {
                mLE(); 

                }
                break;
            case 13 :
                // Bali.g:1:59: OPEN_P
                {
                mOPEN_P(); 

                }
                break;
            case 14 :
                // Bali.g:1:66: CLOSE_P
                {
                mCLOSE_P(); 

                }
                break;
            case 15 :
                // Bali.g:1:74: OPEN_C
                {
                mOPEN_C(); 

                }
                break;
            case 16 :
                // Bali.g:1:81: CLOSE_C
                {
                mCLOSE_C(); 

                }
                break;
            case 17 :
                // Bali.g:1:89: IF
                {
                mIF(); 

                }
                break;
            case 18 :
                // Bali.g:1:92: ELSE
                {
                mELSE(); 

                }
                break;
            case 19 :
                // Bali.g:1:97: WHILE
                {
                mWHILE(); 

                }
                break;
            case 20 :
                // Bali.g:1:103: PRINT
                {
                mPRINT(); 

                }
                break;
            case 21 :
                // Bali.g:1:109: READINT
                {
                mREADINT(); 

                }
                break;
            case 22 :
                // Bali.g:1:117: READSTR
                {
                mREADSTR(); 

                }
                break;
            case 23 :
                // Bali.g:1:125: NUM
                {
                mNUM(); 

                }
                break;
            case 24 :
                // Bali.g:1:129: STR
                {
                mSTR(); 

                }
                break;
            case 25 :
                // Bali.g:1:133: VAR
                {
                mVAR(); 

                }
                break;
            case 26 :
                // Bali.g:1:137: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 27 :
                // Bali.g:1:145: NL
                {
                mNL(); 

                }
                break;
            case 28 :
                // Bali.g:1:148: SPACE
                {
                mSPACE(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\32\6\uffff\1\34\1\36\4\uffff\5\25\14\uffff\1\44\4\25"+
        "\1\uffff\4\25\1\55\3\25\1\uffff\1\61\1\62\5\uffff";
    static final String DFA9_eofS =
        "\65\uffff";
    static final String DFA9_minS =
        "\1\11\1\75\6\uffff\2\75\4\uffff\1\146\1\154\1\150\1\162\1\145\14"+
        "\uffff\1\141\1\163\2\151\1\141\1\uffff\1\145\1\154\1\156\1\144\1"+
        "\141\1\145\1\164\1\137\1\uffff\2\141\1\151\4\uffff";
    static final String DFA9_maxS =
        "\1\175\1\75\6\uffff\2\75\4\uffff\1\146\1\154\1\150\1\162\1\145\14"+
        "\uffff\1\172\1\163\2\151\1\141\1\uffff\1\145\1\154\1\156\1\144\1"+
        "\172\1\145\1\164\1\137\1\uffff\2\172\1\163\4\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\10\2\uffff\1\15\1\16\1\17\1\20\5"+
        "\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\7\1\1\1\12\1\11\1\14\1\13"+
        "\5\uffff\1\21\10\uffff\1\22\3\uffff\1\23\1\24\1\25\1\26";
    static final String DFA9_specialS =
        "\65\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\30\1\27\2\uffff\1\27\22\uffff\1\30\1\7\1\24\1\26\1\uffff"+
            "\1\6\2\uffff\1\12\1\13\1\4\1\2\1\uffff\1\3\1\uffff\1\5\12\23"+
            "\2\uffff\1\11\1\1\1\10\42\uffff\4\25\1\17\3\25\1\16\6\25\1\21"+
            "\1\25\1\22\4\25\1\20\3\25\1\14\1\uffff\1\15",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33",
            "\1\35",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\25",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\32\25",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "\32\25",
            "\32\25",
            "\1\63\11\uffff\1\64",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ATTR | PLUS | MINUS | TIMES | OVER | REM | EQ | NE | GT | GE | LT | LE | OPEN_P | CLOSE_P | OPEN_C | CLOSE_C | IF | ELSE | WHILE | PRINT | READINT | READSTR | NUM | STR | VAR | COMMENT | NL | SPACE );";
        }
    }
 

}