package net.weg.topcar.model.usuarios;

import net.weg.topcar.model.automoveis.Automovel;

import java.util.List;

public interface IUsuario {
    List<Automovel> verAutomoveis();
    List<Automovel> verMeusAutomoveis();
    Automovel verAutomovel(String codigo);
}
