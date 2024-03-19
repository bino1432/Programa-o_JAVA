package Interface;

import Veiculos.Veiculos;

import java.util.List;

public interface IUsuario {
    List<Veiculos> verAutomoveis();
    List<Veiculos> verMeusAutomoveis();

    Veiculos verAutomovel(String codigo);
}
