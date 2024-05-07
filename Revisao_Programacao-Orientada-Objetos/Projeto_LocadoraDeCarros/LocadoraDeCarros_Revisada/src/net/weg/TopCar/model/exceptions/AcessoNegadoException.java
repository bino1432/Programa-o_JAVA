package net.weg.TopCar.model.exceptions;

public class AcessoNegadoException extends Exception{

    public AcessoNegadoException(){
        super("Você não tem permissão para fazer esta ação");
    }

}
