package net.weg.TopCar.model.usuario;

import net.weg.TopCar.dao.IBanco;
import net.weg.TopCar.model.veiculos.Veiculos;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;

public class Vendedor extends Cliente implements IVendedor{

    private static Double salario;

    public Vendedor(String nome, Long cpf, String senha, Double salario) {
        super(nome, cpf, senha);
        this.salario = salario;
    }

    public Double consultarPagamento(){
        return verPagamento();
    }

    @Override
    public void vender(Veiculos veiculo, Cliente usuario) {

    }

    @Override
    public Cliente buscarUsuario(Long cpf, IBanco<Cliente, Long> banco) throws UsuarioNaoEncontradoException {
        return banco.buscarUm(cpf);
    }

    public Double verPagamento(){
        return salario;
    }

    public String verPagamentoComNome() {
        return "vendedor: " + this.getNome() + " Pagamento: " + this.salario;
    }

    @Override
    public String toString() {
        return "Vendedor{}";
    }
}
