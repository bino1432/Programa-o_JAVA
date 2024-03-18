package Usuario;

public class UsuarioNaoEncotradoException extends Exception{
    public UsuarioNaoEncotradoException(String nome) {
        super("O usuario de nome: " + nome + "não encontrado");
    }

    public UsuarioNaoEncotradoException() {
        super("O usuario não encontrado");
    }
}
