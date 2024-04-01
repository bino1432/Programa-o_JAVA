package net.weg.topcar.model.exceptions;

public class UsuarioExistenteException extends Exception{

    public UsuarioExistenteException(){
        super("Usuário ja existe!");
    }


}
