package net.weg.TopCar.dao;

import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;

import java.util.*;

public interface IBanco<T, ID> {
    List<T> buscarTodos();
    T buscarUm(ID id)
            throws UsuarioNaoEncontradoException;
    void adicionar(T novo);
    void remover(ID id)
            throws UsuarioNaoEncontradoException;
    void alterar(ID id,
                 T novo)
            throws UsuarioNaoEncontradoException;
}