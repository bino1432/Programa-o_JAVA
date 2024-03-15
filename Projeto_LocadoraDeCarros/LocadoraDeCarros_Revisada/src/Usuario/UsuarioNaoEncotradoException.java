package Usuario;

public class UsuarioNaoEncotradoException extends Exception{
    public UsuarioNaoEncotradoException() {
        super("Usuario não encontrado");
    }
}
