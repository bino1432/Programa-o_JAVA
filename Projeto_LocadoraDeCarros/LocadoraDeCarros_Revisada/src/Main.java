
import Usuario.*;

import java.util.Scanner;

import static Usuario.Usuario.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente usuario = new Cliente("marcio", "345678", "123", "123");
        Gerente gerente = new Gerente("jean", "2638273", "456",1000);
        Vendedor vendedor = new Vendedor("nicholas", "1525153", "789", 1000);
        Usuario.addUsuario(usuario);
        Usuario.addUsuario(gerente);
        Usuario.addUsuario(vendedor);


        Usuario logado = logar();

            System.out.println("""
                       1 - Ver meus veiculos
                       2 - Ver meu perfil
                    """);
            if(logado instanceof Vendedor) {
                System.out.println("""
                        3 - Vender veiculo
                        4 - Consultar pagamento
                        5 - Ver veiculos
                        """);
                if (logado instanceof Gerente) {
                    System.out.println("""
                            6 - Cadastrar usuario
                            7 - cadastrar veiculo
                            8 - remover veiculo
                            9 - remover usuario
                            """);
                }
            }

            int escolha = sc.nextInt();
        switch (escolha){
                case 1 -> verMeusVeiculos();
                case 2 -> verPerfil(logado);
            }
        if(logado instanceof Vendedor){
        switch (escolha){
            case 3 -> venderVeiculo();
            case 4 -> consultarPagamento();
            case 5 -> verVeiculos();
        }
        }
        if(logado instanceof Gerente){
           switch (escolha){
               case 6 -> cadastrarUsuario();
               case 7 -> cadastrarVeiculo();
               case 8 -> removerVeiculo();
               case 9 -> removerUsuario();
           }
        }

        private static String cadastrarUsuario() {
            return "Usuario cadastrado";
        }

        private static String cadastrarVeiculo() {
            return "Veiculo cadastrado";
        }

        private static String removerVeiculo() {
            return "Veiculo Removido";
        }

        private static String removerUsuario() {
            return "Usuario removido";
        }

        private static String verPerfil(Usuario cliente) {
        return cliente.toString();
    }

    private static String consultarPagamento() {
        return "Pagamento";
    }

    private static String venderVeiculo() {
        return "Veiculo Vendido";
    }

    private static String verMeusVeiculos() {
        return "Veiculos";
    }

    public static Usuario logar(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira seu nome:");
        String nome = sc.next();
        System.out.println("insira a sua senha:");
        String senha = sc.next();

        return Login(nome, senha);

    }
}