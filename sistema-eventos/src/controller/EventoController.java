package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.Principal;

public class EventoController extends Principal {
    public String categoria;
    public String nome;
    public Date horario;
    public String endereco;
    public String descricao;
    
    public void verEventosTodos() throws IOException, ParseException {
        //read("0", "eventos.txt");
        ArrayList<String> proximos = show("null", "eventos.txt");
        for(String proximo:proximos){
            String[] partes = proximo.split("_");
            ArrayList<String> arrayPartes = new ArrayList<>(Arrays.asList(partes));
            //System.out.println(arrayPartes.get(arrayPartes.size() - 2));
                System.out.println("EVENTO: "+arrayPartes.get(0));
                System.out.println("LOCAL: "+arrayPartes.get(1));
                System.out.println("CATEGORIA: "+arrayPartes.get(2));
                System.out.println("DATA: "+arrayPartes.get(3));
                System.out.println("DESCRIÇÃO:  "+arrayPartes.get(4));
                System.out.println("========================"+'\n');
            
        }

    }

    public String criarEvento(String nome, String endereco, String categoria, String horario, String descricao) throws IOException {

        List<String> conteudo = List.of("\n"+nome, endereco, categoria, horario, descricao); 
        
        create("eventos.txt", conteudo);
        return horario.toString();
    }

    public void verificarProximos() throws IOException, ParseException {
        ArrayList<String> proximos = show("null", "eventos.txt");
        for(String proximo:proximos){
            String[] partes = proximo.split("_");
            ArrayList<String> arrayPartes = new ArrayList<>(Arrays.asList(partes));
            //System.out.println(arrayPartes.get(arrayPartes.size() - 2));
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date data = formato.parse(arrayPartes.get(arrayPartes.size() - 2));
            if (data.after(new Date())) {
                System.out.println("EVENTO: "+arrayPartes.get(0));
                System.out.println("LOCAL: "+arrayPartes.get(1));
                System.out.println("CATEGORIA: "+arrayPartes.get(2));
                System.out.println("DATA: "+arrayPartes.get(3));
                System.out.println("DESCRIÇÃO:  "+arrayPartes.get(4));
                System.out.println("========================"+'\n');
            }
        }
    }


}
