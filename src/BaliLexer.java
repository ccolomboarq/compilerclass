// $ANTLR 3.2 Sep 23, 2009 12:02:23 Bali.g 2016-09-14 17:43:37

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BaliLexer extends Lexer {
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

    // $ANTLR start "OPEN_P"
    public final void mOPEN_P() throws RecognitionException {
        try {
            int _type = OPEN_P;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:9:8: ( '(' )
            // Bali.g:9:10: '('
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
            // Bali.g:10:9: ( ')' )
            // Bali.g:10:11: ')'
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

    // $ANTLR start "PRINT"
    public final void mPRINT() throws RecognitionException {
        try {
            int _type = PRINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:11:7: ( 'print' )
            // Bali.g:11:9: 'print'
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

    // $ANTLR start "NUM"
    public final void mNUM() throws RecognitionException {
        try {
            int _type = NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:68:9: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // Bali.g:68:11: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // Bali.g:68:11: ( '0' .. '9' )+
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
            	    // Bali.g:68:11: '0' .. '9'
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

            // Bali.g:68:20: ( '.' ( '0' .. '9' )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Bali.g:68:21: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // Bali.g:68:25: ( '0' .. '9' )+
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
                    	    // Bali.g:68:25: '0' .. '9'
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

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:69:9: ( ( ' ' | '\\t' )+ )
            // Bali.g:69:11: ( ' ' | '\\t' )+
            {
            // Bali.g:69:11: ( ' ' | '\\t' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:70:9: ( ( 'a' .. 'z' )+ )
            // Bali.g:70:11: ( 'a' .. 'z' )+
            {
            // Bali.g:70:11: ( 'a' .. 'z' )+
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
            	    // Bali.g:70:11: 'a' .. 'z'
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Bali.g:71:9: ( ( '\\r' )? '\\n' )
            // Bali.g:71:11: ( '\\r' )? '\\n'
            {
            // Bali.g:71:11: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Bali.g:71:12: '\\r'
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

    public void mTokens() throws RecognitionException {
        // Bali.g:1:8: ( ATTR | PLUS | MINUS | TIMES | OVER | REM | OPEN_P | CLOSE_P | PRINT | NUM | SPACE | VAR | NL )
        int alt7=13;
        alt7 = dfa7.predict(input);
        switch (alt7) {
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
                // Bali.g:1:41: OPEN_P
                {
                mOPEN_P(); 

                }
                break;
            case 8 :
                // Bali.g:1:48: CLOSE_P
                {
                mCLOSE_P(); 

                }
                break;
            case 9 :
                // Bali.g:1:56: PRINT
                {
                mPRINT(); 

                }
                break;
            case 10 :
                // Bali.g:1:62: NUM
                {
                mNUM(); 

                }
                break;
            case 11 :
                // Bali.g:1:66: SPACE
                {
                mSPACE(); 

                }
                break;
            case 12 :
                // Bali.g:1:72: VAR
                {
                mVAR(); 

                }
                break;
            case 13 :
                // Bali.g:1:76: NL
                {
                mNL(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\11\uffff\1\14\4\uffff\3\14\1\22\1\uffff";
    static final String DFA7_eofS =
        "\23\uffff";
    static final String DFA7_minS =
        "\1\11\10\uffff\1\162\4\uffff\1\151\1\156\1\164\1\141\1\uffff";
    static final String DFA7_maxS =
        "\1\172\10\uffff\1\162\4\uffff\1\151\1\156\1\164\1\172\1\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\13\1\14"+
        "\1\15\4\uffff\1\11";
    static final String DFA7_specialS =
        "\23\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\13\1\15\2\uffff\1\15\22\uffff\1\13\4\uffff\1\6\2\uffff\1"+
            "\7\1\10\1\4\1\2\1\uffff\1\3\1\uffff\1\5\12\12\3\uffff\1\1\43"+
            "\uffff\17\14\1\11\12\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16",
            "",
            "",
            "",
            "",
            "\1\17",
            "\1\20",
            "\1\21",
            "\32\14",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ATTR | PLUS | MINUS | TIMES | OVER | REM | OPEN_P | CLOSE_P | PRINT | NUM | SPACE | VAR | NL );";
        }
    }
 

}