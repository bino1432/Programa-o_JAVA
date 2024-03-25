package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;

import java.util.List;


public class Vendedor extends Cliente implements IVendedor  {

    private double salario;

    private double comissoes;

    public Vendedor(String nome, Long cpf, String senha, Long idade, double salario) {
        super(nome, cpf, senha, idade);
        this.salario = salario;
    }

    public String menu() {
        return super.menu() + """
                4 - Vender automóvel;
                5 - Procurar usuário;
                6 - Ver pagamento;
                """;
    }

    public String verPagamento() {
        return ("R$ " + (salario + comissoes));
    }


    public void venderAutomovel(Automovel automovel, Cliente cliente) {
        cliente.adicionarProprioAutomovel(automovel);
        this.setComissoes((automovel.getPreco() * 0.01));
    }

    private void setComissoes(double v) {
        this.comissoes = v;
    }

    @Override
    public void vender(Automovel automovel, Cliente cliente){

    }

    @Override
    public void buscarUsuario(Long cpf, IBanco<Cliente, Long> banco) {

    }

    public String verPagamentoComNome() {
        return this.getNome() + " : " + this.verPagamento();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSalário: R$ " + this.salario +
                "\nComissões: R$ " + this.comissoes + " }\n";
    }


    public List<Automovel> verAutomoveis() {
        return null;
    }

    @Override
    public List<Automovel> verMeusAutomoveis() {
        return null;
    }

    public Automovel verAutomovel(String codigo) {
        return null;
    }
}
