package Usuario;

import Veiculos.Veiculos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Funcionario extends Usuario {

    private static ArrayList<Venda> vendas = new ArrayList<>();
    private static Double salario;

    public Funcionario(String nome, String cpf, String senha, Double salario) {
        super(nome, cpf, senha);
        this.salario = salario;
    }

    public static String procurarCliente(String cpf){
        for (Usuario usuario : Usuario.getUsuarios()){
            if (usuario.getCpf().equals(cpf)){
                return usuario.toString();
            }
        }
        return null;
    }

    public static void addVenda(Venda venda){
        vendas.add(venda);
    }

    public static List<Venda> getVendas(){
        return Collections.unmodifiableList(vendas);
    }

    public static Double verPagamento(){
        return salario;
    }

    @Override
    public Veiculos verMeusVeiculos() {
        for(Veiculos veiculo : getVeiculos()){
          return veiculo;
        }
        return null;
    }

    public static void venderVeiculo(String codigoVeiculo, String cpfCliente) {
    }

    public Double getSalario() {
        return salario;
    }
}
