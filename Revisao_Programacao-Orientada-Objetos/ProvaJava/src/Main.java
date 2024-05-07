import java.util.Scanner;

public class Main {

    static Garcom garcom = new Garcom("Junior", "Rua Memoria ram8GB ddr4", "(47)1234-1234");
    static Cliente cliente = new Cliente("Rafael", "Rua Processador I59400f", "(47)9876-9876");
    static Lanche lanche1 = new Lanche(1, "Pão e Carne", 15.0, 0.500);
    static Lanche lanche2 = new Lanche(2, "Pão Carne e Queijo", 20.0, 0.750);
    static Bebida bebida1 = new Bebida(3, "Suco de Laranja", 5.0, 0.200);
    static Bebida bebida2 = new Bebida(4, "Refrigerante", 8.0, 0.500);
    static Outro outro = new Outro(5,"Pizza 4 Queijos", 25.0, "Média");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        GerenciadorDeCardapio.adicionarProduto(lanche1);
        GerenciadorDeCardapio.adicionarProduto(lanche2);
        GerenciadorDeCardapio.adicionarProduto(bebida1);
        GerenciadorDeCardapio.adicionarProduto(bebida2);
        GerenciadorDeCardapio.adicionarProduto(outro);

        menuInicial();

        do {
            mostrarOpcoes();
            int escolha = sc.nextInt();

            switch (escolha){
                case 1 -> mostrarCardapio();
                case 2 -> System.out.println(adicionarCardapio());
                case 3 -> System.out.println(cadastrarUmPedido());
                case 4 -> visualizarPedidos();
            }
        }while (true);

    }

    public static void menuInicial() {
        System.out.println("""
                Bem Vindo ao restaurante Foods73
                """);
    }

    public static void mostrarCardapio(){
        garcom.exibirMenu();
    }
    public static void visualizarPedidos(){
        cliente.visualizarPedidos();
    }
    public static String adicionarCardapio(){
        System.out.println("Insira o codigo da refeição:");
        int codigo = sc.nextInt();
        if(GerenciadorDeCardapio.verificarExistente(codigo)){
            return "Código já Existente";
        }
        System.out.println("Qual a Descrição da refeição:");
        String descricao = sc.next();
        System.out.println("Qual o Preço da refeição:");
        Double preco = sc.nextDouble();

        System.out.println("""
                Qual o tipo de refeição que deseja adicionar:
                1 - Lanche
                2 - Bebida
                3 - Outro
                """);
        int escolha = sc.nextInt();
        switch (escolha){
            case 1 -> {
                System.out.println("Qual o peso do Lanche:");
                Double peso = sc.nextDouble();
                Produto produto = new Lanche(codigo, descricao, preco, peso);
                GerenciadorDeCardapio.adicionarProduto(produto);
            }
            case 2 -> {
                System.out.println("Qual o volume da Bebida:");
                Double volume = sc.nextDouble();
                Produto produto = new Bebida(codigo, descricao, preco, volume);
                GerenciadorDeCardapio.adicionarProduto(produto);
            }
            case 3 -> {
                System.out.println("Qual o Tamanho:");
                String tamanho = sc.next();
                Produto produto = new Outro(codigo, descricao, preco, tamanho);
                GerenciadorDeCardapio.adicionarProduto(produto);
            }
        }
        return "Refeição adicionada ao Cardapio";
    }

//    public static void removerCardapio(){
//        System.out.println("Qual o Codigo da refeição que deseja remover:");
//        int codigo = sc.nextInt();
//
//        GerenciadorDeCardapio.removerProduto(codigo);
//    }

    public static String cadastrarUmPedido(){
        System.out.println("Qual o status do Pedido:");
        String status = sc.next();

        Pedido pedido = new Pedido(cliente, lanche1, status);

        garcom.cadastrarPedido(cliente, pedido);
        return "Pedido Confirmado";
    }

    public static void mostrarOpcoes(){
        System.out.println("""
                Escolha uma das Opções a Baixo:
                
                1 - Mostrar o Menu
                2 - Adicionar Produto ao Cardapio
                3 - Cadastrar Um Pedido
                4 - Ver status do Pedido
                """);
    }
}