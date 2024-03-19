package net.weg.TopCar.model.usuario;

import net.weg.TopCar.model.exceptions.SenhaIncorretaException;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncotradoException;
import net.weg.TopCar.dao.BancoUsuario;
import net.weg.TopCar.model.Usuario;

public class LoginUsuario {
    private Usuario usuario;
    private BancoUsuario bancoUsuario;

    public Usuario login(String cpf, String senha)
            throws UsuarioNaoEncotradoException,
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
