package Exceptions;

public class UsuarioExistenteException extends Exception{

    public UsuarioExistenteException(){
        super("Usuario já exitente");
    }

    public UsuarioExistenteException(String nome){
        super("Usuario com o nome: " + nome + " já exitente");
    }

}
