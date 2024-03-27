package model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class Principal {

    public void create(String arquivo, List<String> conteudo) throws IOException {
       FileWriter escreve = new FileWriter("src/database/"+arquivo, true);
       escreve.write(String.join("_", conteudo));
       escreve.close();
    }

    public String read(String nome, String file) throws IOException {
        Path arq = Paths.get("src/database/" + file);

        List<String> linhas = Files.readAllLines(arq);
             if (nome.equals("0")) {
            for(String linha:linhas){
                //System.out.println(linha);
                String[] partes = linha.split("_");
                for(String parte:partes){
                    System.out.println(parte);
                }
                System.out.println("================================");
            }
        }else{
            for(String linha:linhas){
                String[] partes = linha.split("_");
                if (partes[0].equals(nome)) {
                    //for(String parte:partes){
                    //    System.out.println(parte);
                    //}
                    return linha;
                }
            }
        }
        return file;
           
    }

    public ArrayList<String> show(String nome, String file) throws IOException {
        Path arq = Paths.get("src/database/" + file);

        List<String> linhas = Files.readAllLines(arq);
        if (nome.equals("null")) {
            ArrayList<String> retorno = new ArrayList<String>();
            for(String linha:linhas){
                retorno.add(linha);
            }
            return retorno;
        }
        return null;
       
    }
 
    public void deleteLine(String nome, String file) throws IOException {
        List<String> linhas = new ArrayList<>();
        BufferedReader leitor = new BufferedReader(new FileReader("src/database/" + file));
        String linha;

        // Ler o conteúdo do arquivo e armazená-lo na lista de linhas
        while ((linha = leitor.readLine()) != null) {
            linhas.add(linha);
        }
        leitor.close();

        // Remover a linha com o nome especificado
        for (int i = 0; i < linhas.size(); i++) {
            String[] partes = linhas.get(i).split("_");
            if (partes[0].equals(nome)) {
                linhas.remove(i);
                break; // Parar após encontrar e remover a linha
            }
        }

        // Reescrever o conteúdo atualizado no arquivo
        BufferedWriter escritor = new BufferedWriter(new FileWriter("src/database/" + file));
        for (String l : linhas) {
            escritor.write(l);
            escritor.newLine();
        }
        escritor.close();
    }
}

// nome, endereço, categoria, horário e descrição