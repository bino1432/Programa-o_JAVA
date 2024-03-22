package net.weg.TopCar.model.usuario;

import net.weg.TopCar.dao.IBanco;
import net.weg.TopCar.model.veiculos.Veiculos;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;

import java.util.List;

public interface ICliente {
    List<Veiculos> verAutomoveis(IBanco<Veiculos, String> banco);
    List<Veiculos> verMeusAutomoveis();
    Veiculos verAutomovel(String codigo, IBanco<Veiculos, String> banco) throws UsuarioNaoEncontradoException;
}
