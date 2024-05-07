import java.util.ArrayList;
import java.util.List;

public class Combo extends Produto{

    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    private Double desconto;

    public Combo(int codigo, String descricao, Double preco, Double desconto) {
        super(codigo, descricao, preco);
        this.desconto = desconto;
    }

    @Override
    public Double calcularPreco(Double desconto) {
        Double precoComDesconto = 0.0;
        precoComDesconto = getPreco() - (getPreco() / 100) * desconto;

        return precoComDesconto;
    }

    @Override
    public String exibirDetalhes() {
        return "Combo: " +
                "Código = " + getCodigo() +
                ", Preço = " + getPreco() +
                ", Descrição = " + getDescricao() +
                ", Desconto = " + this.desconto;
    }

}
