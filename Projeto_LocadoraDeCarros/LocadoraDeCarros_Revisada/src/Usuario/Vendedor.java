package Usuario;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha, salario);
    }

    public static float consultarPagamento(){
        return Funcionario.verPagamento();
    }

    @Override
    public String toString() {
        return "Vendedor{}";
    }
}
