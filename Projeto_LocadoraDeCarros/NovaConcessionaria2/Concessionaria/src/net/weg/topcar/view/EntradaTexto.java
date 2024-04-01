package net.weg.topcar.view;

import java.util.InputMismatchException;

public class EntradaTexto extends Entrada<String>{

    @Override
    protected boolean validaEntrada(String valor) {
        return valor.equals("");
    }

    @Override
    public String leia() throws InputMismatchException {
        return sc.next();
    }


}
