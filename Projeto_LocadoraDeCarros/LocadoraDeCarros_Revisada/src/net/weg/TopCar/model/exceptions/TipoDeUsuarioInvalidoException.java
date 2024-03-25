package net.weg.TopCar.model.exceptions;

import net.weg.TopCar.model.usuario.Cliente;

public class TipoDeUsuarioInvalidoException extends Exception{

    public TipoDeUsuarioInvalidoException(Cliente cliente){
            super("Tipo de Usuario invalido" +
                    "O usuario de CPF: " + cliente.getCpf + "é um "
                    + cliente.getClass().getSimpleName().toLowerCase());
    }

}
