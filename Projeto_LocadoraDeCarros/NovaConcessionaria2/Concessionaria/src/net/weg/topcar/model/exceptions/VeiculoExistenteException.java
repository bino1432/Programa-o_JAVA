package net.weg.topcar.model.exceptions;

public class VeiculoExistenteException extends Exception{
    public VeiculoExistenteException(String codigo) {
        super("Veiculo exixtente com o codigo" + codigo + "!");
    }

}
