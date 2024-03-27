package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Principal;

public class UserController extends Principal{

    public void exibirTudo() throws IOException {
        read("0", "usuarios.txt");
    }

   public void criarUser(String nome, String idade, String evento) throws IOException {
        List<String> conteudo = List.of("\n"+nome, idade, evento);
        create("usuarios.txt", conteudo);
   }

   public void participar(String nome, String novoEvento) throws IOException {
        String dadosUser = read(nome, "usuarios.txt");
        String[] dados = dadosUser.split("_");
        ArrayList<String> listaDados = new ArrayList<>(Arrays.asList(dados));
        listaDados.remove(listaDados.size() - 1);
        listaDados.add(novoEvento);
        System.out.println(listaDados);
        
        deleteLine(nome, "usuarios.txt");
        create("usuarios.txt",listaDados);

    }

    public void verificarParticipacao(String nome) throws IOException {
        String dadosUser = read(nome, "usuarios.txt");
        String[] dados = dadosUser.split("_");
        ArrayList<String> listaDados = new ArrayList<>(Arrays.asList(dados));
        System.out.println("\n----------------------"+listaDados.get(listaDados.size() - 1));

    }

    public void cancelar(String nome) throws IOException {
        String dadosUser = read(nome, "usuarios.txt");
        String[] dados = dadosUser.split("_");
        ArrayList<String> listaDados = new ArrayList<>(Arrays.asList(dados));
        listaDados.remove(listaDados.size() - 1);
        listaDados.add("0");
        deleteLine(nome, "usuarios.txt");
        create("usuarios.txt",listaDados);

        System.out.println("Você cancelou sua participação !\n");
    }
}
