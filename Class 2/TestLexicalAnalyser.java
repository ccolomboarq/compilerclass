import java.util.ArrayList;

public class TestLexicalAnalyser
{
    public static void main(String[] args)
    {
        String s = " 1 + 2.0* ( 03 *4.56 + 78.9)";
        System.out.println("Input: '" + s + "'");
        
        LexicalAnalyser la = new LexicalAnalyser(s);
        
        ArrayList<Token> tokens = la.analyse();
        System.out.println(tokens);
    }
}