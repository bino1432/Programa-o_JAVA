package net.weg.topcar.dao;

import net.weg.topcar.model.exceptions.AcessoNegadoException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Cliente;

import java.util.List;

public interface IBanco<T,ID> {
    List<T> buscarTodos();
    T buscarUm(ID id)
            throws ObjetoNaoEncontradoException;
    void adicionar(T novo);
    Cliente remover(ID id)
            throws ObjetoNaoEncontradoException, AcessoNegadoException;
    Boolean existe(ID id);
    void alterar(ID id,
                 T novo)
            throws ObjetoNaoEncontradoException;
}
