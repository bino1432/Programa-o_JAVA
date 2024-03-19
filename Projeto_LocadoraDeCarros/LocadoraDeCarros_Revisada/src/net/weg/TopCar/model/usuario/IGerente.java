package net.weg.TopCar.model.usuario;

import net.weg.TopCar.model.exceptions.PrecoInvalidoException;
import net.weg.TopCar.model.Usuario;
import net.weg.TopCar.model.Veiculos;

import java.util.List;

public interface IGerente extends IFuncionario {
    void alterarPreco(String codigo, float novoPreco) throws PrecoInvalidoException;
    String removerVeiculo(String codigo);
    void cadastrarVeiculo(Veiculos veiculo);
    float verPagamentos();
    String removerUsuario(String cpf);
    Float verPagamentoDeUmVendedor(String cpf);
    void cadastrarUsuario(Usuario usuario);
    void editarUmUsuario(Usuario novoUsuario);
    void editarVeiculo(Veiculos novoVeiculo);
    List<Vendedor> verVendedores();
    List<Cliente> verClientes();
}
