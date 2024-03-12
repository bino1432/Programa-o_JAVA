
import Usuario.*;
import Veiculos.Veiculos;
import Veiculos.Carro;
import Veiculos.Moto;
import Veiculos.Caminhao;

import java.io.StringReader;
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
                case 2 -> verVeiculos();
                case 3 -> verDetalheVeiculo();
            }
            if (logado instanceof Usuario) {
                switch (escolha) {
                    case 4 -> verMeusVeiculos();
                }
            }
            if (logado instanceof Funcionario) {
                switch (escolha) {
                    case 5 -> venderVeiculo();
                    case 6 -> procurarCliente();
                    case 7 -> verPagamento();
                }
            }
            if (logado instanceof Gerente){
                switch (escolha) {
                    case 8 -> cadastrarVeiculo();
                    case 9 -> removerVeiculo();
                    case 10 -> editarVeiculo();
                    case 11 -> cadastrarUsuario();
                    case 12 -> removerUsuario();
                    case 13 -> editarUsuario();
                    case 14 -> verVendedores();
                    case 15 -> verClientes();
                    case 16 -> verPagamentoVendedor();
                    case 17 -> verPagamentoUmVendedor();
                }
            }
        }

    }

    private static void verPagamentoUmVendedor() {
        System.out.println("Qual o cpf do vendedor?");
        String cpf = sc.next();

        for (Venda venda : Funcionario.getVendas()){
            if(logado.getCpf().equals(cpf)){
                venda.toString();
            }
        }
    }

    private static void verPagamentoVendedor() {
        for (Venda venda : Funcionario.getVendas()){
            venda.toString();
        }
    }

    private static void verClientes() {
        for (Usuario cliente : Usuario.getUsuarios()){
            cliente.toString();
        }
    }

    private static void verVendedores() {
        for (Usuario vendedor : Usuario.getUsuarios()){
            vendedor.toString();
        }
    }

    private static void editarUsuario() {

    }

    private static void removerUsuario() {
        System.out.println("Qual o cpf do usuario ue deseja remover?");
        String cpf = sc.next();

        Gerente.removerUsuario(cpf);
    }
    private static void cadastrarUsuario() {
        System.out.println("Qual o nome do Usuario");
        String nome = sc.next();
        System.out.println("Qual a senha do Usuario");
        String senha = sc.next();
        System.out.println("Qual o cpf do Usuario");
        String cpf = sc.next();
        System.out.println("Qual o cnh do Usuario");
        String cnh = sc.next();

        Gerente.cadastrarUsuario(nome, senha, cpf, cnh);
    }

    private static void editarVeiculo() {
        System.out.println("Qual o codigo do veiculo que deseja alterar:");
        String codigo = sc.next();
        System.out.println("Qual o novo preço do veiculo:");
        float preco = sc.nextFloat();

        Gerente.mudarPreco(codigo, preco);
    }

    private static void removerVeiculo() {
        System.out.println("Qual o código do veiculo que deseja remover?");
        String codigo = sc.next();

        Gerente.removerVeiculo(codigo);
    }
    private static void cadastrarVeiculo() {
        Veiculos veiculoGenerico = null;

        System.out.println("Qual o código do veiculo que deseja cadastrar?");
        String codigo = sc.next();
        System.out.println("Qual o preço do veiculo que deseja cadastrar?");
        float preco = sc.nextFloat();
        System.out.println("Qual a marca do veiculo que deseja cadastrar?");
        String marca = sc.next();
        System.out.println("Qual a placa do veiculo que deseja cadastrar?");
        String placa = sc.next();
        System.out.println("O veiculo que deseja cadastrar é novo?");
        boolean novo = sc.nextBoolean();
        System.out.println("Qual o status do veiculo que deseja cadastrar?");
        String status = sc.next();
        System.out.println("Qual a quilometragem do veiculo que deseja cadastrar?");
        int quilometragem = sc.nextInt();
        System.out.println("Qual o modelo do veiculo que deseja cadastrar?");
        String modelo = sc.next();
        System.out.println("Qual o ano do veiculo que deseja cadastrar?");
        int ano = sc.nextInt();

        System.out.println("""
        Qual o tipo de veiculo que deseja cadastrar
        1 - Carro
        2 - Moto
        3 - Caminhão
        """);

        int tipoDoVeiculo = sc.nextInt();

        switch (tipoDoVeiculo){
            case 1 -> veiculoGenerico = new Carro(codigo, preco, marca, placa, novo, status,
                    quilometragem, modelo, ano);
            case 2 -> veiculoGenerico = new Moto(codigo, preco, marca, placa, novo, status,
                    quilometragem, modelo, ano);
            case 3 -> {
                System.out.println("Qual o peso maximo suportado?");
                String pesoMaximo = sc.next();
                System.out.println("Qual o Comprimento?");
                int comprimento = sc.nextInt();
                System.out.println("Qual a quantidade de rodas?");
                int quantidadeDeRodas = sc.nextInt();

                veiculoGenerico = new Caminhao(codigo, preco, marca, placa, novo, status,
                quilometragem, modelo, ano, pesoMaximo, comprimento, quantidadeDeRodas);
            }
        }

        Gerente.cadastrarVeiculo(veiculoGenerico);
    }
    
    private static void verPagamento() {
        System.out.println("O seu pagamento é de: ");

        Funcionario.verPagamento();
    }

    private static void procurarCliente() {
        System.out.println("Qual o cpf do Cliente que deseja procurar?");
        String cpf = sc.next();

        Funcionario.procurarCliente(cpf);
    }
    private static void venderVeiculo() {
        System.out.println("Qual o cpf do vendedor:");
        String cpfVendedor = sc.next();
        System.out.println("Qual o cpf do comprador:");
        String cpfCliente = sc.next();
        System.out.println("Qual o coidigo do veiculo vendido:");
        String codigo = sc.next();

        for(Veiculos veiculo : Veiculos.getVeiculo()){
            if(veiculo.getCodigo().equals(veiculo)){
                Funcionario.venderVeiculo(codigo, cpfCliente);
                Veiculos.removeVeiculo(veiculo);

                Venda venda = new Venda(cpfVendedor, cpfCliente, codigo);
                Funcionario.addVenda(venda);
            }
        }
    }

    private static void verMeusVeiculos(){
        for (Veiculos veiculo : logado.getVeiculos()){
            veiculo.toString();
        }
    }
    private static void verDetalheVeiculo() {
        System.out.println("Qual o codigo do veiculo que deseja ver?");
        String codigo = sc.next();

        Veiculos.detalheVeiculo(codigo);
    }

    private static void verVeiculos() {
        for (Veiculos veiculo : Veiculos.getVeiculo()){
            veiculo.toString();
        }
    }

    public static void logar(){

        System.out.println("Insira seu nome:");
        String nome = sc.next();
        System.out.println("insira a sua senha:");
        String senha = sc.next();

        logado = Usuario.Login(nome, senha);
    }

    public static void menuPadrao(){
        System.out.println("""
                1 - Login
                2 - Ver Veiculos
                3 - Ver Detalhes de veiculo
                """);
    }

    public static void menuCliente(){
        System.out.println("""
                4 - Ver meus Veiculos
                """);
    }

    public static void menuFuncionario(){
        System.out.println("""
                5 - Vender um Veiculo
                6 - Procurar um Cliente
                7 - Ver Pagamento   
                """);
    }

    public static void menuGerente(){
        System.out.println("""
                8 - Cadastrar Veiculo
                9 - Remover Veiculo
                10 - Editar Veiculo
                11 - Cadastrar Usuario
                12 - Remover Usuario
                13 - Editar Usuario
                14 - Ver Vendedores
                15 - Ver Clientes
                16 - Ver Pagamento dos Vendedores
                17 - Ver Pagamento de um Vendedor
                """);
    }
}