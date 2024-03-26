package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.FalhaNaCompraException;


public interface IVendedor{
    void vender(Automovel automovel,Cliente cliente) throws FalhaNaCompraException;
    void buscarUsuario(Long cpf, IBanco<Cliente, Long> banco);
    String verPagamento();
}
