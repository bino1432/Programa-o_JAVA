public class Outro extends Produto{

    private String tamanho;

    public Outro(int codigo, String descricao, Double preco, String tamanho) {
        super(codigo, descricao, preco);
        this.tamanho = tamanho;
    }

    @Override
    public Double calcularPreco(Double desconto) {
        Double precoComDesconto = 0.0;
        precoComDesconto = getPreco() - (getPreco() / 100) * desconto;

        return precoComDesconto;
    }

    @Override
    public String exibirDetalhes() {
        return "Outro: " +
                "Código = " + getCodigo() +
                ", Preço = " + getPreco() +
                ", Descrição = " + getDescricao() +
                ", tamanho = " + this.tamanho;
    }
}
