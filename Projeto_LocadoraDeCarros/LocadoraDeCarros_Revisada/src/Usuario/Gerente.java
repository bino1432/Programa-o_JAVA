package Usuario;

import Veiculos.Veiculos;

public class Gerente extends Funcionario{
    public Gerente(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha, salario);
    }

    @Override
    public void venderVeiculo(String codigoVeiculo, String cpfCliente) {

    }

    public static void removerVeiculo(String codigo){
        for(Veiculos veiculo : getVeiculos()){
            if(veiculo.getCodigo().equals(codigo)){
                Veiculos.getVeiculo().remove(veiculo);
            }
        }
    }

    public static void mudarPreco(String codigo, float preco){
        for(Veiculos veiculo : Veiculos.getVeiculo()){
            if(veiculo.getCodigo().equals(codigo)){
                Veiculos.setPreco(preco);
            }
        }
    }

    public static void cadastrarVeiculo(Veiculos veiculo){
        Veiculos.getVeiculo().add(veiculo);
    }

    public static void cadastrarUsuario(String nome, String senha, String cpf, String cnh){
        Usuario usuario = new Cliente(nome, senha, cpf, cnh);
        getUsuarios().add(usuario);
    }

    public static void removerUsuario(String cpf){
        for (Usuario usuario : getUsuarios()){
            if(usuario.getCpf().equals(cpf)){
                getUsuarios().remove(usuario);
            }
        }
    }

    @Override
    public String toString() {
        return "Gerente{}";
    }
}
