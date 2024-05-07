import java.util.ArrayList;

public class Pedido {

    private Cliente cliente;
    private Produto produto;
    private String status;

    public void adicionarProduto(Produto produto){
        this.produto = produto;
    }

//    public void removerItemCombo(int codigo){
//        for(Produto produto : Combo.getProdutos()){
//            if(produto.equals(codigo)){
//                itens.remove(produto);
//            }
//        }
//    }

    public Double calcularTotal(){
        return produto.getPrecoProduto();
    }
    public void confirmarPedido(){
        System.out.println(status);
    }

    @Override
    public String toString() {
        return "Pedido: " +
                "Cliente = " + cliente +
                ", Produto = " + produto.exibirDetalhes() +
                ", Status = 's" + status + '\'' +
                '}';
    }

    public Pedido(Cliente cliente, Produto produto, String status) {
        this.cliente = cliente;
        this.produto = produto;
        this.status = status;
    }
}
