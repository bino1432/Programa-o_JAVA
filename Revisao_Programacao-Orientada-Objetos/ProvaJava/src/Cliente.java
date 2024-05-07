import java.util.ArrayList;

public class Cliente extends Pessoa{

    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public void fazerPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void cancelarPedido(Pedido pedido){
        for(Pedido pedido1 : pedidos){
            if(pedido1.equals(pedido)){
                pedidos.remove(pedido);
            }
        }
    }
    public void visualizarPedidos(){
        for(Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }

    public Cliente() {
    }

    public Cliente(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
    }

}
