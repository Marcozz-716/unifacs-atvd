package view;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import controller.EventoController;
import controller.UserController;

public class Comandos {
    public int laco() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        EventoController eventoController = new EventoController();
        UserController userController = new UserController();
        int i;
        do {
            System.out.println("////////////\nMENU:\n(1) Ver eventos disponíveis\n(2) Cadastrar Usuário\n(3) Cadastrar Evento\n(4) Participar de evento\n(5) Ver eventos que participo\n(6) Cancelar participação no evento\n(7) Verificar eventos próximos\n(0) Quebrar laço\nDIGITE A OPÇÃO DESEJADA: ");
            i = input.nextInt();

            switch (i) {
                case 1:
                    eventoController.verEventosTodos();
                    break;
                case 2:
                    List<String> atributosUser = inputCriarUser();
                    userController.criarUser(atributosUser.get(0), atributosUser.get(1), atributosUser.get(2));
                    System.out.println("\nUsuário cadastrado com sucesso !");
                    break;
                case 3:
                    List<String> atributosEvento = inputCriarEvento();
                    eventoController.criarEvento(atributosEvento.get(0), atributosEvento.get(1), atributosEvento.get(2), atributosEvento.get(3), atributosEvento.get(4));
                    System.out.println("\nEvento cadastrado com sucesso !");
                    break;
                case 4:
                    List<String> atributosParticipacao = inputParticipar();
                    userController.participar(atributosParticipacao.get(0), atributosParticipacao.get(1));
                    System.out.println("\nVocê agora é um participante deste evento !");
                    break;
                case 5:
                    String verify = verificar();
                    userController.verificarParticipacao(verify);
                    break;
                case 6:
                    String verifyName = verificar();
                    userController.cancelar(verifyName);
                    break;
                case 7:
                    eventoController.verificarProximos();
                default:
                    break;
            }

        } while (i != 0);
        input.close();
        return i;
        
    }

    public List<String> inputCriarUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("INSIRA O NOME: ");
        String nome = input.nextLine();

        System.out.println("INSIRA A IDADE: ");
        String idade = input.nextLine();

        System.out.println("ESCOLHA UM EVENTO PARA PARTICIPAR: ");
        String evento = input.nextLine();

        List<String> retorno = List.of(nome, idade, evento);
        return retorno;

    }

    public List<String> inputCriarEvento() {
        //nome, endereco, categoria, horario.toString(), descricao
        Scanner input = new Scanner(System.in);
        System.out.println("INSIRA O NOME: ");
        String nome = input.nextLine();

        System.out.println("INSIRA O ENDEREÇO: ");
        String endereco = input.nextLine();

        System.out.println("INSIRA A CATEGORIA (show, festa ou evento esportivo): ");
        String categ = input.nextLine();

        System.out.println("INSIRA A DATA E O HORÁRIO (dd/mm/yyyy hh:mm): ");
        String horario = input.nextLine();   
        
        System.out.println("INSIRA A DESCRIÇÃO DO EVENTO:  ");
        String desc = input.nextLine();

        List<String> retorno = List.of(nome, endereco, categ, horario, desc);
        return retorno;
    }

    public List<String> inputParticipar() {
        Scanner input = new Scanner(System.in);
        System.out.println("INSIRA O SEU NOME: ");
        String nome = input.nextLine();

        System.out.println("INSIRA O EVENTO QUE VOCÊ DESEJA PARTICIPAR: ");
        String evento = input.nextLine();

        List<String> retorno = List.of(nome, evento);
        return retorno;

        
    }

    public String verificar() {
        Scanner input = new Scanner(System.in);
        System.out.println("INSIRA O SEU NOME: ");
        String nome = input.nextLine();
        return nome;

    }
}
