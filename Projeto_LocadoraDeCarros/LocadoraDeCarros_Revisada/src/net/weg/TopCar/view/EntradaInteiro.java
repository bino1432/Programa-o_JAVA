package net.weg.TopCar.view;

import java.util.InputMismatchException;

public class EntradaInteiro extends Entrada<Long>{

    @Override
    protected boolean validacaoEntrada(Long valor) {
        return false;
    }

    @Override
    public Long leia() throws InputMismatchException {
        return sc.nextLong();
    }

}
