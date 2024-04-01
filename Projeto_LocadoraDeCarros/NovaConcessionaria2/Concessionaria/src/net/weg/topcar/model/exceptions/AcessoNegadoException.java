package net.weg.topcar.model.exceptions;

public class AcessoNegadoException extends Exception{

    public AcessoNegadoException(String usuarioNaoEUmVendedor){
        super("Usuario nao possui acesso");
    }
}
