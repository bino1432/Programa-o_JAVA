public abstract class Produto {

    private int codigo;
    private String descricao;
    private Double preco;

    public abstract Double calcularPreco(Double desconto);
    public abstract String exibirDetalhes();

    public Produto(int codigo, String descricao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public Double getPrecoProduto() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }
}
