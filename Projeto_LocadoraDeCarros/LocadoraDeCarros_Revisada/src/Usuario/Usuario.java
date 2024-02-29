package Usuario;

import Veiculos.Veiculos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Usuario {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Veiculos> meusVeiculos = new ArrayList<>();

    private String nome;
    private static String cpf;
    private String senha;

    public Usuario(String nome, String cpf, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public static String getCpf(){
        return cpf;
    }

    public static List<Veiculos> getVeiculos(){
        return Collections.unmodifiableList(meusVeiculos);
    }

    public static List<Usuario> getUsuarios(){
        return Collections.unmodifiableList(usuarios);
    }

    public static void addUsuario(Usuario usuario){
        if (usuario instanceof Cliente){
            usuarios.add(usuario);
        }
    }

    public static Usuario verUsuarios() {
        for (Usuario user : usuarios) {
            return user;
        }
        return null;
    }

    public Veiculos verMeusVeiculos() {
        for (Veiculos veiculo : meusVeiculos) {
            return veiculo;
        }
        return null;
    }

    public static Usuario Login(String nome, String senha){
        for(Usuario user : usuarios){
            if (user.nome.equals(nome) && user.senha.equals(senha)){
                return user;
            }
        }
        return null;
    }
}
