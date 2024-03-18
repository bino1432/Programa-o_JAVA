package Exceptions;

public class PrecoInvalidoException extends Exception{

    public PrecoInvalidoException(){
        super("Preço invalido! (preço precisa ser maior que 0)");
    }

}
