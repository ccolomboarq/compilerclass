import java.io.*;

public class ArquivoEscrita
{
    private BufferedWriter bufferedWriter;
    
    public ArquivoEscrita(String nomeArquivo)
    {
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(nomeArquivo);
            bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch (IOException e)
        {
            System.err.println("Arquivo nao pode ser escrito: " + nomeArquivo);
            //e.printStackTrace();
        }
    }
    
    public void escreverLinha(String linha)
    {
        try
        {
            if (bufferedWriter != null)
            {
                bufferedWriter.write(linha + "\n");
            }
        }
        catch (IOException e)
        {
            System.err.println("Erro de escrita no arquivo");
            //e.printStackTrace();
        }
    }
    
    public void fechar()
    {
        try
        {
            if (bufferedWriter != null)
            {
                bufferedWriter.close();
            }
        }
        catch(IOException e)
        {
            System.err.println("Erro ao fechar o arquivo");
            //e.printStackTrace();
        }
        bufferedWriter = null;
    }
}
