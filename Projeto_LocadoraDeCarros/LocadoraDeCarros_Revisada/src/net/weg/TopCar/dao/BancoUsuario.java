package net.weg.TopCar.dao;

import net.weg.TopCar.model.exceptions.UsuarioNaoEncotradoException;
import net.weg.TopCar.model.Usuario;

import java.util.ArrayList;

public class BancoUsuario {
    private static ArrayList<Usuario> listaUsuarios;

    public void alterar(String cpf, Usuario novoUsuario) throws UsuarioNaoEncotradoException {
        Usuario usuario = procurarUsuario(cpf);
        listaUsuarios.set(listaUsuarios.indexOf(usuario), novoUsuario);
    }

    public ArrayList<Usuario> buscarTodosUsuarios() {
        return listaUsuarios;
    }

    public void remover(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }
    public Usuario procurarUsuario(String cpf) throws UsuarioNaoEncotradoException {
        for (Usuario usuario: listaUsuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncotradoException(cpf);
    }

    public void remover(String cpf) throws UsuarioNaoEncotradoException {
        listaUsuarios.remove(procurarUsuario(cpf));
    }


    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

}