package net.weg.TopCar.model.usuario;

import net.weg.TopCar.dao.IBanco;
import net.weg.TopCar.model.exceptions.PrecoInvalidoException;
import net.weg.TopCar.model.Veiculos;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;
import net.weg.TopCar.model.exceptions.VeiculoExistenteException;

import java.util.List;

public interface IGerente extends IVendedor {
    void alterarPreco(String codigo, float novoPreco) throws PrecoInvalidoException;
    String removerVeiculo(String codigo);
    void cadastrarVeiculo(Veiculos veiculo) throws VeiculoExistenteException, PrecoInvalidoException;
    float verPagamentos();
    String removerUsuario(String cpf);
    Float verPagamentoDeUmVendedor(String cpf);
    void cadastrarUsuario(Cliente usuario);
    String editarUmUsuario(Long cpf, Cliente usuario, IBanco<Cliente, Long> banco) throws UsuarioNaoEncontradoException;
    void editarVeiculo(Veiculos novoVeiculo, IBanco<Veiculos, Long> banco) throws UsuarioNaoEncontradoException;
    List<Vendedor> verVendedores();
    List<net.weg.TopCar.model.usuario.Cliente> verClientes();
}
