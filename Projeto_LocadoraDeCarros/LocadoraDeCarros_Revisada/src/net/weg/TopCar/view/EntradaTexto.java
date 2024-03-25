package net.weg.TopCar.view;

import java.util.InputMismatchException;

public class EntradaTexto extends Entrada<String>{
    @Override
    protected boolean validacaoEntrada(String valor) {
        return !valor.isEmpty();
    }

    public String leia() throws InputMismatchException {
        return sc.next();
    }
}