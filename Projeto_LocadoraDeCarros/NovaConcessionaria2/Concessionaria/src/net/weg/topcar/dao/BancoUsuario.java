package net.weg.topcar.dao;

import net.weg.topcar.model.exceptions.AcessoNegadoException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.IGerente;

import java.util.Collections;
import java.util.List;

public class BancoUsuario implements
        IBanco<Cliente, String> {
    private List<Cliente> listaClientes;

    public List<Cliente> buscarTodos() {
        return Collections.unmodifiableList(
                listaClientes);
    }

    public Cliente buscarUm(String cpf)
            throws ObjetoNaoEncontradoException {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ObjetoNaoEncontradoException(cpf);
    }

    public void adicionar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente remover(String cpf) throws ObjetoNaoEncontradoException, AcessoNegadoException {
        Cliente cliente = buscarUm(cpf);
        if (cliente instanceof IGerente) {
            listaClientes.remove(cliente);
        } else {
            throw new AcessoNegadoException("Usuario nao e um vendedor");
        }
        return cliente;
    }

    @Override
    public Boolean existe(String cpf) {
        try {
            buscarUm(cpf);
            return true;
        } catch (ObjetoNaoEncontradoException e){
            return false;
        }
    }

    public void alterar(String cpf,
                        Cliente novoCliente)
            throws ObjetoNaoEncontradoException {
        Cliente cliente = buscarUm(cpf);
        listaClientes.set(
                listaClientes.indexOf(cliente),
                novoCliente);
    }

}
