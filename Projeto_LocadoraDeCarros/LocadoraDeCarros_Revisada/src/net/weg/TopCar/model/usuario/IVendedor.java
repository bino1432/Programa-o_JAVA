package net.weg.TopCar.model.usuario;

import net.weg.TopCar.dao.IBanco;
import net.weg.TopCar.model.Veiculos;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;

public interface IVendedor extends ICliente{

    void vender(Veiculos veiculo, Cliente usuario);
    Cliente buscarUsuario(Long cpf, IBanco<Cliente, Long> banco) throws UsuarioNaoEncontradoException;
    Double verPagamento();
}
