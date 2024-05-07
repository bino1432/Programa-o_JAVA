package net.weg.TopCar.model.exceptions;

public class UsuarioNaoEncontradoException extends Exception{
    public UsuarioNaoEncontradoException(String nome) {
        super("O usuario de nome: " + nome + "não encontrado");
    }

    public UsuarioNaoEncontradoException() {
        super("O usuario não encontrado");
    }
}
