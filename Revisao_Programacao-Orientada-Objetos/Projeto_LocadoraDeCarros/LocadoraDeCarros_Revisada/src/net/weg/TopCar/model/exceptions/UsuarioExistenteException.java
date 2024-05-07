package net.weg.TopCar.model.exceptions;

public class UsuarioExistenteException extends Exception{

    public UsuarioExistenteException(){
        super("net.weg.TopCar.model.Usuario já exitente");
    }

    public UsuarioExistenteException(String nome){
        super("net.weg.TopCar.model.Usuario com o nome: " + nome + " já exitente");
    }

}
