package net.weg.TopCar.dao;

import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;
import net.weg.TopCar.model.usuario.Cliente;

import java.util.ArrayList;

public class BancoUsuario {
    private static ArrayList<Cliente> listaUsuarios;

    public void alterar(String cpf, Cliente novoUsuario) throws UsuarioNaoEncontradoException {
        Cliente usuario = procurarUsuario(cpf);
        listaUsuarios.set(listaUsuarios.indexOf(usuario), novoUsuario);
    }

    public ArrayList<Cliente> buscarTodosUsuarios() {
        return listaUsuarios;
    }

    public void remover(Cliente usuario) {
        listaUsuarios.remove(usuario);
    }
    public Cliente procurarUsuario(String cpf) throws UsuarioNaoEncontradoException {
        for (Cliente usuario: listaUsuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncontradoException(cpf);
    }

    public void remover(String cpf) throws UsuarioNaoEncontradoException {
        listaUsuarios.remove(procurarUsuario(cpf));
    }


    public void adicionarUsuario(Cliente usuario) {
        listaUsuarios.add(usuario);
    }

}