package net.weg.TopCar.view;

import java.util.InputMismatchException;

public class EntradaTexto extends Entrada<String>{
    @Override
    protected boolean validacaoEntrada(String valor) {
        return false;
    }

    public String leia() throws InputMismatchException {
        return sc.next();
    }
}