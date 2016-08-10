import java.util.ArrayList;

public class SyntacticAnalyser
{
    private ArrayList<Token> tokens;
    private int level = 0;
    
    public SyntacticAnalyser() {}

    private void call(String s) { 
        for (int i = 0; i < level; i++) { 
            System.out.print("  "); 
        }
        System.out.println(s);
    }

    public void analyse(ArrayList<Token> tokens)
    {
        this.tokens = tokens;
        tokens.add(new Token('$'));
        S();
        System.out.println("remaining tokens: " + tokens);
    }
    
    private void S()
    {
        E();
    }
    
    private void E() // E -> T | T + E
    {
        T();
        if (tokens.get(0).getType() == '+') {
            tokens.remove(0); 
            E();
            System.out.println("ADIC");
        }
        level--;
    }
    
    private void T() // T -> F | F * T
    {
        F();
        if (tokens.get(0).getType() == '*') {
            tokens.remove(0);
            T();
            System.out.println("MULT");
        }
        //level--;
    }
    
    private void F() // F -> n | (E)
    {
        if (tokens.get(0).getType() == 'n') {
            Token t = tokens.remove(0); System.out.println(t.getValue());
        }
        else if (tokens.get(0).getType() == '(') {
            tokens.remove(0); //System.out.print("( ");
            E();
            if (tokens.get(0).getType() != ')') {
                System.out.println("error: unexpected symbol " + tokens.get(0).getType());
                System.exit(0);
            }
            tokens.remove(0); //System.out.print(") ");
        }
        else {
            System.out.println("error: unexpected symbol " + tokens.get(0).getType());
            System.exit(0);
        }
        level--;
    }
}
