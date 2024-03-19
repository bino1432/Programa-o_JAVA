package Interface;

import Veiculos.Veiculos;
import Usuario.Usuario;

public interface IFuncionario extends IUsuario {

    void vender(Veiculos veiculo, Usuario usuario);
    Usuario buscarUsuario(String cpf);
    String verPagamento();
}
