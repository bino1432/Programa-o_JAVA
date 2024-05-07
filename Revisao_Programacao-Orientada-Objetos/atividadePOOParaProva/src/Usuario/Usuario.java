package Usuario;

public abstract class Usuario {

    private String nome;
    private int idade;
    private String endereco;

    public Usuario(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }
}
