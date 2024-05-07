package net.weg.TopCar.model.exceptions;

public class VeiculoExistenteException extends Exception{

    public VeiculoExistenteException(){
        super("Veiculo já existente");
    }

    public VeiculoExistenteException(Long codigo){
        super("Veiculo com o código: " + codigo + " já existe");
    }

}
