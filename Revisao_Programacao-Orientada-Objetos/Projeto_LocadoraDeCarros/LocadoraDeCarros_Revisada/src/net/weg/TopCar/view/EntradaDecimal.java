package net.weg.TopCar.view;

import java.util.InputMismatchException;

public class EntradaDecimal extends Entrada<Double>{

    @Override
    protected boolean validacaoEntrada(Double valor) {
        return valor > 0.0;
    }

    @Override
    public Double leia() throws InputMismatchException {
        return sc.nextDouble();
    }

}
