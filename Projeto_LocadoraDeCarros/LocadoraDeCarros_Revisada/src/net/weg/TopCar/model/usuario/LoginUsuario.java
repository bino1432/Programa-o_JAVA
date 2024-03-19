package net.weg.TopCar.model.usuario;

import net.weg.TopCar.model.exceptions.SenhaIncorretaException;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;
import net.weg.TopCar.dao.BancoUsuario;

public class LoginUsuario {
    private Cliente usuario;
    private BancoUsuario bancoUsuario;

    public Cliente login(String cpf, String senha)
            throws UsuarioNaoEncontradoException,
            SenhaIncorretaException {
        this.usuario = bancoUsuario.procurarUsuario(cpf);
        validarSenha(senha);
        return this.usuario;
    }

    public LoginUsuario(BancoUsuario bancoUsuario) {
        this.bancoUsuario = bancoUsuario;
    }

    private void validarSenha(String senha) throws SenhaIncorretaException {
        if (!this.usuario.getSenha().equals(senha)) {
            return;
        }else {
            throw new SenhaIncorretaException();
        }
    }
}
