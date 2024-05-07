package net.weg.topcar.model.usuarios;

import net.weg.TopCar.model.usuario.Cliente;
import net.weg.TopCar.dao.BancoCliente;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.SenhaIncorretaException;

;

public class LoginUsuario {
    private final BancoCliente bancoUsuario;
    private Cliente usuario;

    public LoginUsuario(
            BancoCliente bancoUsuario){
        this.bancoUsuario = bancoUsuario;
    }
    public Cliente login(Long cpf,
                         String senha)
            throws ObjetoNaoEncontradoException,
            SenhaIncorretaException {
        this.usuario = this.bancoUsuario
                .buscarUm(cpf);
        validarSenha(senha);
        return usuario;
    }
    private void validarSenha(
            String senha)
            throws SenhaIncorretaException {
        if(!usuario.getSenha()
                .equals(senha)){
            throw new SenhaIncorretaException();
        }
    }
}
