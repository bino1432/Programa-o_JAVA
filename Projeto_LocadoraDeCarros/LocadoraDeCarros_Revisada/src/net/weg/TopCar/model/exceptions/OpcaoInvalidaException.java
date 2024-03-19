package net.weg.TopCar.model.exceptions;

public class OpcaoInvalidaException extends Exception{

    public OpcaoInvalidaException(){
        super("Opção escolhida não existe");
    }

}
