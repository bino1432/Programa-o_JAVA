public class Singleton {

    private static Singleton instance;
    private String nome;
    private int idade;
    private String email;
    private String cpf;

    private Singleton(String nome, int idade, String email, String cpf){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
    }

    public static Singleton getInstance(String nome, int idade, String email, String cpf) {
        if(instance == null){
            instance = new Singleton(nome, idade, email, cpf);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
