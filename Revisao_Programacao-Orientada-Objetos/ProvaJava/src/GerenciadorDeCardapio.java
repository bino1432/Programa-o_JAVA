import java.util.ArrayList;

public class GerenciadorDeCardapio {

    private static ArrayList<Produto> cardapio = new ArrayList<Produto>();

    public static void adicionarProduto(Produto produto){
        cardapio.add(produto);
    }
    public static void removerProduto(int codigo){
        for(Produto produto : cardapio){
            if(produto.getCodigo() == codigo){
                cardapio.remove(produto);
            }
        }
    }
    public void editarProduto(int codigo, Produto novoProduto){
        for(Produto produto : cardapio){
            if (produto.equals(codigo)){
                cardapio.remove(produto);
                cardapio.add(novoProduto);
            }
        }
    }
    public static void listarProdutos(){
        for(Produto produto : cardapio){
            System.out.println(produto.exibirDetalhes());
        }
    }

    public static boolean verificarExistente(int codigo){
        for(Produto produto : cardapio){
            if (produto.getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }
}
