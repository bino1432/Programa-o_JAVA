package net.weg.TopCar.model;

import net.weg.TopCar.model.exceptions.SenhaIncorretaException;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncotradoException;

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

    public static Usuario procurarUsuario(String cpf) {
        for (Usuario user : usuarios) {
            if (user.cpf.equals(cpf)){
                return user;
            }
        }
        return null;
    }

    public List<Veiculos> getVeiculos(){
        return Collections.unmodifiableList(meusVeiculos);
    }

    public static List<Usuario> getUsuarios(){
        return Collections.unmodifiableList(usuarios);
    }

    public static void addUsuario(Usuario usuario){
            usuarios.add(usuario);
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

    public static Usuario Login(String nome, String senha)
            throws SenhaIncorretaException,
            UsuarioNaoEncotradoException {
        for(Usuario user : usuarios){
            if (user.nome.equals(nome)){
                if (user.senha.equals(senha)){
                    return user;
                }
                throw new SenhaIncorretaException();
            }
        }
        throw new UsuarioNaoEncotradoException(nome);
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void alterarUsuario(Usuario novoUsuario) {

    }
}
