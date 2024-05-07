package net.weg.TopCar.model.exceptions;

public class PrecoInvalidoException extends Exception{

    public PrecoInvalidoException(){
        super("Preço invalido! (preço precisa ser maior que 0)");
    }

}
