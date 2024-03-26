package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Automovel;

import java.util.ArrayList;
import java.util.List;

public class AutomovelController {

    public void verAutomoveis(){

    }

    private List<Automovel> filtrarAutimoveisDisponiveis(List<Automovel> listaAutomoveis){
        List<Automovel> listaAutimoveisDisponiveis = new ArrayList<>();
        for(Automovel automovel : listaAutomoveis) {
            if(!automovel.isComprado()){
                listaAutimoveisDisponiveis.add(automovel);

            }
            }
        return listaAutimoveisDisponiveis;
    }

}
