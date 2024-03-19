package net.weg.TopCar.model.usuario;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, String cpf, String senha, Double salario) {
        super(nome, cpf, senha, salario);
    }

    public static Double consultarPagamento(){
        return Funcionario.verPagamento();
    }

    @Override
    public String toString() {
        return "Vendedor{}";
    }
}
