package net.weg.topcar.model.exceptions;

import net.weg.topcar.model.usuarios.Cliente;

public class TipoUsuarioInvalidoException extends Exception{
    public TipoUsuarioInvalidoException(Cliente cliente) {
        super("Tipo de usuario invalido! " + "O usuario de CPF" + cliente.getCpf() + "é um " + cliente.getClass().getSimpleName());
    }
}
