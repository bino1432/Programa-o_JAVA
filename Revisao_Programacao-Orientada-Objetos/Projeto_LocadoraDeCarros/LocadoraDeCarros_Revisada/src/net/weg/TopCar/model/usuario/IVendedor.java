package net.weg.topcar.model.usuarios;

import net.weg.TopCar.model.usuario.Cliente;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;


public interface IVendedor{
    void vender(Automovel automovel,Cliente cliente);
    void buscarUsuario(Long cpf, IBanco<Cliente, Long> banco);
    String verPagamento();
}
