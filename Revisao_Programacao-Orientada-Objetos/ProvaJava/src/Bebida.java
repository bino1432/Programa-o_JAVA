public class Bebida extends Produto{

    private Double volume;

    public Bebida(int codigo, String descricao, Double preco, Double volume) {
        super(codigo, descricao, preco);
        this.volume = volume;
    }

    @Override
    public Double calcularPreco(Double desconto) {
        Double precoComDesconto = 0.0;
        precoComDesconto = getPreco() - (getPreco() / 100) * desconto;

        return precoComDesconto;
    }

    @Override
    public String exibirDetalhes() {
        return "Bebida: " +
                "Código = " + getCodigo() +
                ", Preço = " + getPreco() +
                ", Descrição = " + getDescricao() +
                ", Volume = " + this.volume;
    }
}
