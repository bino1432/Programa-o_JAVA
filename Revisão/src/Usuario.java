import java.util.ArrayList;

public abstract class Usuario {

    private final static ArrayList<Usuario> Usuarios = new ArrayList<>();

    private String nome;
    private String usuario;
    private String senha;

    public Usuario(String nome, String usuario, String senha){
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void alterarSenha(String senha){
        this.senha = senha;
    }

    public void alterarNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Usuario login(String username, String senha){
        for(Usuario usuarioAvaliado : Usuarios){
            if(usuarioAvaliado.usuario.equals(username) &&
                    usuarioAvaliado.senha.equals(senha)){
                return usuarioAvaliado;
            }
        }
        return null;
    }
}