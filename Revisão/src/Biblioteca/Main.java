package Biblioteca;

import Biblioteca.Midias.*;
import Biblioteca.Usuarios.Bibliotecario;
import Biblioteca.Usuarios.Cliente;
import Biblioteca.Usuarios.Funcionario;
import Biblioteca.Usuarios.Usuario;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado;
    public static void main(String[] args) {
        System.out.println("Bem vindo à biblioteca!");

        do {
            System.out.println("""
                1 - Login
                2 - Sair
                """);

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> login();
                case 2 -> System.exit(0);
            }
        } while(true);
    }



    public static <istanceof> void menuUsuario() {
        do {
            System.out.println("""
                1 - Alterar nome;
                2 - Alterar senha;
                3 - Ver empréstimos;
                4 - Ver perfil;
                5 - Consultar disponibilidade de midia no estoque da biblioteca;
                """);
            System.out.printf("0 - Logout");

            if (usuarioLogado instanceof Funcionario) {
                System.out.println("""
                    6 - Cadastrar cliente;
                    7 - Remover usuário;
                    8 - Emprestar midia;
                    9 - Devolução de midia
                    """);

                if (usuarioLogado instanceof Bibliotecario) {
                    System.out.println("""
                        10 - Cadastro de midia;
                        11 - Remover midia;
                        """);
                }
            }

            int escolha = scanner.nextInt();

            switch (escolha){
                case 1 -> alterarNome();
                case 2 -> alterarSenha();
                case 3 -> verEmprestimos();
                case 4 -> verPerfil();
                case 5 -> verMidiaDisponivel();
            }
            if (usuarioLogado instanceof Funcionario){
                switch (escolha){
                    case 6 -> cadastroUsuario();
                    case 7 -> removerUsuario();
                    case 8 -> emprestarMidia();
                    case 9 -> devolverMidia();
                }
            }
            if (usuarioLogado instanceof Bibliotecario){
                switch (escolha){
                    case 10 -> cadastrarMidia();
                }
            }

        }while (usuarioLogado != null);
    }

    public static void login() {

        do {
            System.out.println("Insira o usuário: ");
            String usuarioNome = scanner.next();
            System.out.println("Insira a senha: ");
            String senha = scanner.next();
            usuarioLogado = Usuario.login(usuarioNome, senha);
        }while (usuarioLogado == null);
        menuUsuario();
    }

    private static void logout() {
        usuarioLogado = null;
    }

    public static void cadastroUsuario() {
        System.out.println("Insira o seu nome: ");
        String nome = scanner.next();
        System.out.println("Insira o usuário: ");
        String usuario = scanner.next();
        System.out.println("Insira a senha: ");
        String senha = scanner.next();
        Usuario cliente = new Cliente(nome, usuario, senha);
        Usuario.addUsuario(cliente);
    }

    public static void alterarNome(){
        System.out.println("Insira o novo nome");
        String nome = scanner.next();
        usuarioLogado.alterarNome(nome);
    }

    public static void alterarSenha(){
        System.out.println("Insira a nova senha");
        String senha = scanner.next();
        usuarioLogado.alterarSenha(senha);
    }

    private static void verEmprestimos() {
        System.out.println("Aqui estão os seus emprestimos");
        for (Midia midia : usuarioLogado.getEmprestimos()){
            System.out.println(midia);
        }
    }

    private static void verPerfil() {
        usuarioLogado.toString();
    }

    private static void verMidiaDisponivel() {
        System.out.println("Insira o codigo da midia que deseja consultar");
        int codigo = scanner.nextInt();
        System.out.println(usuarioLogado.consultarMidia(codigo));
    }

    private static void removerUsuario() {
        System.out.println("Qual username que deseja remover:");
        String username = scanner.next();

        Usuario usuario = Usuario.getUsuario(username);

        if (usuario != null){
            Funcionario.removeUsuario(usuario);
        }
    }

    private static void emprestarMidia() {
        System.out.println("Insira o username que deseja emprestar a midia");
        String username = scanner.next();
        Usuario usuario = Usuario.getUsuario(username);

        System.out.println("Qual o codigo da midia que você deseja emprestar");
        int codigo = scanner.nextInt();

        if(usuario == null){
            System.out.println("Usuario não existe");
        } else {
            Midia midia = Midia.procurarMidia(codigo);
            if(midia == null){
                System.out.println("Midia não existe");
            } else {
                Funcionario.emprestarMidia(midia, usuario);
            }
        }
    }

    private static void devolverMidia() {
        System.out.println("Insira o username de quem deseja devolver a midia");
        String username = scanner.next();
        Usuario usuario = Usuario.getUsuario(username);

        System.out.println("Qual o codigo da midia que você deseja devolver");
        int codigo = scanner.nextInt();

        if(usuario == null){
            System.out.println("Usuario não existe");
        } else {
            Midia midia = Midia.procurarMidia(codigo);
            if(midia == null){
                System.out.println("Midia não existe");
            } else {
                Funcionario.devolverMidia(midia, usuario);
            }
        }
    }

    private static void cadastrarMidia() {
        System.out.println("""
                Qual tipo de midia você quer adicionar
                1 - DVD
                2 - Jornal
                3 - Revista
                4 - Livro
                """);

        int escolha = scanner.nextInt();

        System.out.println("Insira o codigo dessa midia");

        int codigo = scanner.nextInt();

        Midia midia = null;

        switch (escolha){
            case 1:
                midia = new DVD(codigo);
                break;
            case 2:
                midia = new Jornal(codigo);
                break;
            case 3:
                midia = new Revista(codigo);
                break;
            case 4:
                midia = new Livro(codigo);
        }

        Midia.addMidia(midia);
    }
}