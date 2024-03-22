package net.weg.TopCar.view;

import java.util.InputMismatchException;

public class EntradaDecimal extends Entrada<Double>{

    @Override
    protected boolean validacaoEntrada(Double valor) {
        return false;
    }

    @Override
    public Double leia() throws InputMismatchException {
        return sc.nextDouble();
    }

}
