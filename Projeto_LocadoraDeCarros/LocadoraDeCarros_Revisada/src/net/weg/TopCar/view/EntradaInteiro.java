package net.weg.TopCar.view;

public class EntradaInteiro extends Entrada<Integer>{

    @Override
    public Integer leia(){
        return sc.nextInt();
    }

}
