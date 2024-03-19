package net.weg.TopCar.view;

import java.util.InputMismatchException;

public class EntradaTexto extends Entrada<String>{
    public String leia() throws InputMismatchException {
        return sc.next();
    }
}