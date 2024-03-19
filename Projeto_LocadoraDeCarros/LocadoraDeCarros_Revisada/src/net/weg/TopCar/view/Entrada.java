package net.weg.TopCar.view;

import java.util.Scanner;

public abstract class Entrada<T> {
    protected final Scanner sc = new Scanner(System.in);
 
    public abstract T leia();
}