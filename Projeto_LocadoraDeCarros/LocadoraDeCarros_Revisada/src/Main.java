
import Usuario.*;

import java.util.Scanner;

import static Usuario.Usuario.*;

public class Main {
    private static Cliente usuario = new Cliente("marcio", "345678", "123", "123");
    private static Vendedor vendedor = new Vendedor("jean", "2638273", "456",1000);
    private static Gerente gerente = new Gerente("nicholas", "1525153", "789", 1000);
    private static Usuario logado = null;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Usuario.addUsuario(usuario);
        Usuario.addUsuario(gerente);
        Usuario.addUsuario(vendedor);

        while (true){
            menuPadrao();

            if (logado instanceof Usuario) {
                menuCliente();
            }
            if (logado instanceof Funcionario) {
                menuFuncionario();
            }
            if (logado instanceof Gerente) {
                menuGerente();
            }
            System.out.println("""
                0 - LogOut
                """);

            int escolha = sc.nextInt();

            switch (escolha) {
                case 0 -> System.exit(0);
                case 1 -> logar();
                case 2 -> Cadastrar();
                case 3 -> verVeiculos();
                case 4 -> verDetalheVeiculo();
            }
            if (logado instanceof Usuario) {
                switch (escolha) {
                    case 5 -> verMeusVeiculos();
                }
            }
            if (logado instanceof Funcionario) {
                switch (escolha) {
                    case 6 -> venderVeiculo();
                    case 7 -> procurarCliente();
                    case 8 -> verPagamento();
                }
            }
            if (logado instanceof Gerente){
                switch (escolha) {
                    case 9 -> cadastrarVeiculo();
                    case 10 -> removerVeiculo();
                    case 11 -> editarVeiculo();
                    case 12 -> cadastrarUsuario();
                    case 13 -> removerUsuario();
                    case 14 -> editarUsuario();
                    case 15 -> verVendedores();
                    case 16 -> verClientes();
                    case 17 -> verPagamentoVendedor();
                    case 18 -> verPagamentoUmVendedor();
                }
            }
        }

    }

    private static void verPagamentoUmVendedor() {
    }

    private static void verPagamentoVendedor() {
    }

    private static void verClientes() {
    }

    private static void verVendedores() {
    }

    private static void editarUsuario() {
    }

    private static void removerUsuario() {
    }
    private static void cadastrarUsuario() {
    }

    private static void editarVeiculo() {
    }

    private static void removerVeiculo() {
    }
    private static void cadastrarVeiculo() {
    }
    
    private static void verPagamento() {
    }

    private static void procurarCliente() {
    }
    private static void venderVeiculo() {
    }

    private static void verMeusVeiculos(){
    }
    private static void verDetalheVeiculo() {
    }

    private static void verVeiculos() {
    }

    private static void Cadastrar() {
    }

    public static void logar(){

        System.out.println("Insira seu nome:");
        String nome = sc.next();
        System.out.println("insira a sua senha:");
        String senha = sc.next();

        logado = Usuario.Login(nome, senha);
        System.out.println(logado);
    }

    public static void menuPadrao(){
        System.out.println("""
                1 - Login
                2 - Cadastrar
                3 - Ver Veiculos
                4 - Ver Detalhes de veiculo
                """);
    }

    public static void menuCliente(){
        System.out.println("""
                5 - Ver meus Veiculos
                """);
    }

    public static void menuFuncionario(){
        System.out.println("""
                6 - Vender um Veiculo
                7 - Procurar um Cliente
                8 - Ver Pagamento   
                """);
    }

    public static void menuGerente(){
        System.out.println("""
                9 - Cadastrar Veiculo
                10 - Remover Veiculo
                11 - Editar Veiculo
                12 - Cadastrar Usuario
                13 - Remover Usuario
                14 - Editar Usuario
                15 - Ver Vendedores
                16 - Ver Clientes
                17 - Ver Pagamento dos Vendedores
                18 - Ver Pagamento de um Vendedor
                """);
    }
}