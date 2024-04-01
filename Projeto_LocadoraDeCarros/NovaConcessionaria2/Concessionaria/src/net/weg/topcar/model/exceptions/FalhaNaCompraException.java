package net.weg.topcar.model.exceptions;

public class FalhaNaCompraException extends Exception{

    public FalhaNaCompraException(String texto) {
        super("Falha ao realizar a compra: " + texto);
    }

}
