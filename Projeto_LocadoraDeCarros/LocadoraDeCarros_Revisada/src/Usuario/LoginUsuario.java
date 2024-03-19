package Usuario;

import Exceptions.SenhaIncorretaException;
import Exceptions.UsuarioNaoEncotradoException;
;

public class LoginUsuario {

    private String cpf;
    private String senha;
    private Usuario usuario;

    public Usuario login(BancoUsuario bancoUsuario)
            throws UsuarioNaoEncotradoException,
            SenhaIncorretaException {
        usuario = bancoUsuario.procurarUsuario(cpf);
        validarSenha();
            return usuario;
    }

    private boolean validarSenha(){
        if (usuario.getSenha().equals(senha)){
            return true;
        }
        throw new SenhaIncorretaException();
    }
}
