package Usuario;

import Exceptions.SenhaIncorretaException;
import Exceptions.UsuarioNaoEncotradoException;

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
