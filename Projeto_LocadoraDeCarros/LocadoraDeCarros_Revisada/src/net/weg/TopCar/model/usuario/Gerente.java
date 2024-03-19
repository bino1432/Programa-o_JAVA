package net.weg.TopCar.model.usuario;

import net.weg.TopCar.dao.IBanco;
import net.weg.TopCar.model.exceptions.*;
import net.weg.TopCar.model.Veiculos;

import java.util.List;

public class Gerente extends Vendedor implements IGerente {
    public Gerente(String nome, Long cpf, String senha, double salario) {
        super(nome, cpf, senha, salario);
    }

    @Override
    public void alterarPreco(String codigo, float novoPreco) throws PrecoInvalidoException {

    }

    public static void removerVeiculo(Long codigo){
        for(Veiculos veiculo : Veiculos.getVeiculo()){
            if(veiculo.getCodigo().equals(codigo)){
                Veiculos.getVeiculo().remove(veiculo);
            }
        }
    }

    public static void mudarPreco(String codigo, float preco) throws PrecoInvalidoException{

        if (preco <= 0){
            throw new PrecoInvalidoException();
        }

        for(Veiculos veiculo : Veiculos.getVeiculo()){
            if(veiculo.getCodigo().equals(codigo)){
                Veiculos.setPreco(preco);
            }
        }
    }

    public void cadastrarVeiculo(Veiculos veiculo)
            throws VeiculoExistenteException,
            PrecoInvalidoException {

        if(veiculo.getPreco() <= 0){
            throw new PrecoInvalidoException();
        }

        for (Veiculos veiculoExistente : Veiculos.getVeiculo()){
            if (veiculo.getCodigo().equals(veiculoExistente.getCodigo())){
                throw new VeiculoExistenteException(veiculo.getCodigo());
            }
        }
        Veiculos.addVeiculo(veiculo);
    }

    @Override
    public float verPagamentos() {
        return 0;
    }

    @Override
    public String removerUsuario(String cpf) {
        return null;
    }

    @Override
    public String removerVeiculo(String codigo) {
        return null;
    }

    public static void cadastrarUsuario(String nome, String senha, Long cpf, String cnh)
            throws UsuarioExistenteException{
        for (Cliente usuarioExistente : getUsuarios()){
            if (usuarioExistente.getCpf().equals(cpf)){
                throw new UsuarioExistenteException(nome);
            }
        }
        Cliente usuario = new Cliente(nome, cpf, senha);
        Cliente.addUsuario(usuario);
    }

    public static void removerUsuario(Long cpf){
        for (Cliente usuario : getUsuarios()){
            if(usuario.getCpf().equals(cpf)){
                getUsuarios().remove(usuario);
            }
        }
    }

    @Override
    public Float verPagamentoDeUmVendedor(String cpf) {
        return null;
    }

    @Override
    public void cadastrarUsuario(Cliente usuario) {

    }

    @Override
    public String editarUmUsuario(Long cpf, Cliente usuario, IBanco<Cliente, Long> banco)
            throws UsuarioNaoEncontradoException {
            banco.alterar(cpf, usuario);
            return "Usuario editado";
    }

    @Override
    public void editarVeiculo(Veiculos novoVeiculo,IBanco<Veiculos, Long> banco) {

    }

    @Override
    public List<Vendedor> verVendedores() {
        return null;
    }

    @Override
    public List<Cliente> verClientes() {
        return null;
    }

    @Override
    public String toString() {
        return "Gerente{}";
    }
}
