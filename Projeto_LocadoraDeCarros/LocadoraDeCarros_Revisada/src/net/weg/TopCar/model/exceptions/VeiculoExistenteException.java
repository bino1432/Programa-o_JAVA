package net.weg.TopCar.model.exceptions;

public class VeiculoExistenteException extends Exception{

    public VeiculoExistenteException(){
        super("Veiculo já existente");
    }

    public VeiculoExistenteException(String codigo){
        super("Veiculo com o código: " + codigo + " já existe");
    }

}
