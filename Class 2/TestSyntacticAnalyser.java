import java.util.ArrayList;

public class TestSyntacticAnalyser
{
    public static void main(String[] args)
    {
        String s = "1 + 2 * 3";
        System.out.println("Entrada: '" + s + "'");
        
        LexicalAnalyser la = new LexicalAnalyser(s);
        ArrayList<Token> tokens = la.analyse();
        
        SyntacticAnalyser sa = new SyntacticAnalyser();
        sa.analyse(tokens);
    }
}
