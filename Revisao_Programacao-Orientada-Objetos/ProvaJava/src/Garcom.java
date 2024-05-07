public class Garcom extends Pessoa{

    private Double pagamento;

    public void cadastrarPedido(Cliente cliente, Pedido pedido){
        cliente.fazerPedido(pedido);
    }

    public void exibirMenu(){
        GerenciadorDeCardapio.listarProdutos();
    }

    public void adicionarItemAoPedido(Pedido pedido, Produto item){
        pedido.adicionarProduto(item);
    }

    public void removerItemDoPedido(Pedido pedido, int codigo){

    }

    public void confirmarPedido(Pedido pedido){
        pedido.confirmarPedido();
    }

    public void calcularPagamento(Pedido pedido){
       this.pagamento = (pedido.calcularTotal() / 100) * 5;
    }

    public Garcom() {
    }

    public Garcom(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
    }
}
