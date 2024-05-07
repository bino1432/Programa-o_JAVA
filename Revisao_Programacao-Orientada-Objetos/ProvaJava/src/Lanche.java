public class Lanche extends Produto{

    private Double peso;

    public Lanche(int codigo, String descricao, Double preco, Double peso) {
        super(codigo, descricao, preco);
        this.peso = peso;
    }

    @Override
    public Double calcularPreco(Double desconto) {
        Double precoComDesconto = 0.0;
        precoComDesconto = getPreco() - (getPreco() / 100) * desconto;

        return precoComDesconto;
    }

    @Override
    public String exibirDetalhes() {
        return "Lanche: " +
                "Código = " + getCodigo() +
                ", Preço = " + getPreco() +
                ", Descrição = " + getDescricao() +
                ", Peso = " + this.peso;
    }
}
