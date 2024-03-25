package net.weg.topcar.model.exceptions;

public class AcessoNegadoException extends RuntimeException{
    public AcessoNegadoException(String mensagem){
        super("Permissão negada " + mensagem);
    }
}
