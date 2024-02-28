package Usuario;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha, salario);
    }

    @Override
    public void venderVeiculo(String codigoVeiculo, String cpfCliente) {

    }

    public static float consultarPagamento(){
        return Funcionario.verPagamento();
    }
}
