package Exceptions;

public class OpcaoInvalidaException extends Exception{

    public OpcaoInvalidaException(){
        super("Opção escolhida não existe");
    }

}
