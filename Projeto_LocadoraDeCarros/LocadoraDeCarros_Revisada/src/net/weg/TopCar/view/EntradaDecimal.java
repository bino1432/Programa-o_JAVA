package net.weg.TopCar.view;

import java.util.InputMismatchException;

public class EntradaDecimal extends Entrada<Double>{

    @Override
    public Double leia() throws InputMismatchException {
        return sc.nextDouble();
    }

}
