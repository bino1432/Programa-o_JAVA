package Exceptions;

public class VeiculoNaoEncontradoException extends Exception{
    public VeiculoNaoEncontradoException() {
        super("Veiculo com não encontrado");
    }

    public VeiculoNaoEncontradoException(String codigo) {
        super("Veiculo com o código: " + codigo +  " não encontrado");
    }

}
