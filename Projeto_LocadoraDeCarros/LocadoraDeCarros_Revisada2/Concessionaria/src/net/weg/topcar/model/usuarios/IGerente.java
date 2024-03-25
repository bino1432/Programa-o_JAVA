package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.AcessoNegadoException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.List;

public interface IGerente {
    String registrarAutomovel(IBanco<Automovel, String> banco,
            Automovel automovel);

    String removerAutomovel(IBanco<Automovel, String> banco,
            String codigo) throws ObjetoNaoEncontradoException;

    String editarAutomovel(Automovel automovelEditado, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException;

    String editarPreco(
            String codigo, double preco, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException;

    String registrarUsuario(
            Cliente cliente, IBanco<Cliente, Long> banco) throws AcessoNegadoException;

    String removerUsuario(Long cpf, IBanco<Cliente, Long> banco) throws AcessoNegadoException, ObjetoNaoEncontradoException;

    String editarUsuario(Cliente clieteEditado, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;

    List<Vendedor> verVendedores(IBanco<Cliente, Long> banco);

    List<Cliente> verClientes(IBanco<Cliente, Long> banco);

    List<String> verPagamentoVendedores(IBanco<Cliente, Long> banco);

    String verPagamentoVendedor(Long cpf,IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;
}
