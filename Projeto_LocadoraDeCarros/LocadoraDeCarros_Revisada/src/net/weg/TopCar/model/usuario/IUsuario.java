package net.weg.TopCar.model.usuario;

import net.weg.TopCar.model.Veiculos;

import java.util.List;

public interface IUsuario {
    List<Veiculos> verAutomoveis();
    List<Veiculos> verMeusAutomoveis();

    Veiculos verAutomovel(String codigo);
}
