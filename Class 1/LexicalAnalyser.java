import java.util.ArrayList;

/* Implementa um analisador lexico para expressoes aritmeticas
 */
public class LexicalAnalyser
{
    private String entrada; // armazena a string a ser analisada
    private int indice;     // indica a posicao do proximo caracter a ser lido
    
    /* Construtor desta classe, recebe a string a ser analisada e
     * inicializa os dois atributos privados
     */
    public LexicalAnalyser(String s)
    {
        entrada = s + "$"; // adiciona um caracter para indicar o final da string
        indice = 0;
    }
    
    /* Metodo privado que analisa a string e retorna o proximo token encontrado,
     * na forma de um objeto do tipo "Token", avancando neste processo o
     * atributo "indice"
     */
    private Token getToken()
    {
        // Consome qualquer espacos que estejam presentes a partir do ponto atual
        while (Character.isWhitespace(entrada.charAt(indice)))
        {
            indice++;
        }
        
        // Verifica se encontrou um operador, retornando o mesmo na forma de token
        if (entrada.charAt(indice) == '+' | entrada.charAt(indice) == '*' |
            entrada.charAt(indice) == '(' | entrada.charAt(indice) == ')')
        {
            Token t = new Token(entrada.charAt(indice));
            indice++;
            return (t);
        }
        
        // Verifica se e um digito, analisando ate o final de um numero valido
        if (Character.isDigit(entrada.charAt(indice)))
        {
            int inicio = indice; // guarda posicao inicial para uso posterior
            indice++;
            while (Character.isDigit(entrada.charAt(indice)))
            {
                // Repete verificacao para obter toda a parte inteira do numero
                indice++;
            }
            if (entrada.charAt(indice) == '.')
            {
                // Se encontrar um ponto, tenta obter parte fracionaria do mesmo
                indice++;
                if (Character.isDigit(entrada.charAt(indice)))
                {
                    indice++;
                    while (Character.isDigit(entrada.charAt(indice)))
                    {
                        indice++;
                    }
                }
                else
                {
                    // Se apos o ponto nao tiver um digito, encontramos um erro
                    System.out.println("Erro: caracter invalido '" +
                                       entrada.charAt(indice) +
                                       "' em expressao numerica na posicao " + indice);
                    return (null);
                }
            }
            
            // Converte o trecho da entrada que contem o numero para um
            // valor "double" e retorna um token numerico
            String tmp = entrada.substring(inicio, indice);
            return (new Token(Double.parseDouble(tmp)));
        }
        else
        {
            // Foi encontrado um caracter diferente de espaco, operador ou digito
            if (entrada.charAt(indice) != '$')
            {
                // Como nao e o indicador de final da string, imprime um erro
                System.out.println("Erro: caracter desconhecido '" +
                                   entrada.charAt(indice) + "' na posicao " + indice);
            }
            return (null);
        }
    }
    
    /* Metodo que efetua toda a analise, repetindo a leitura de tokens
     * ate que a entrada termine ou que aconteca um erro, retornando um
     * vetor de tokens
     */
    public ArrayList<Token> analyse()
    {
        ArrayList<Token> lista = new ArrayList<Token>(); // declaracao de um vetor de tokens
        Token token;
        while ((token = getToken()) != null)
        {
            lista.add(token);
        }
        return (lista);
    }
}
