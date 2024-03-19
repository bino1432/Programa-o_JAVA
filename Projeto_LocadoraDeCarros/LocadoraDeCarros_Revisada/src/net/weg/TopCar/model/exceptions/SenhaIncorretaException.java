package net.weg.TopCar.model.exceptions;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException(){
        super("Senha Incorreta");
    }
}
