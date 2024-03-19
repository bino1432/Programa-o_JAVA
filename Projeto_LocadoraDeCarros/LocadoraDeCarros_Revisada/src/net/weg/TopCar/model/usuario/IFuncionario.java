package net.weg.TopCar.model.usuario;

import net.weg.TopCar.model.Veiculos;
import net.weg.TopCar.model.Usuario;

public interface IFuncionario extends IUsuario {

    void vender(Veiculos veiculo, Usuario usuario);
    Usuario buscarUsuario(String cpf);
    String verPagamento();
}
