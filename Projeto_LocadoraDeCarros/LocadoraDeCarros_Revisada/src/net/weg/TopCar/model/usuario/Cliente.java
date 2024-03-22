package net.weg.TopCar.model.usuario;

import net.weg.TopCar.dao.IBanco;
import net.weg.TopCar.model.veiculos.Veiculos;
import net.weg.TopCar.model.exceptions.SenhaIncorretaException;
import net.weg.TopCar.model.exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente implements ICliente{

    private static ArrayList<Cliente> usuarios = new ArrayList<>();
    private static ArrayList<Veiculos> meusVeiculos = new ArrayList<>();

    private String nome;
    private static Long cpf;
    private String senha;
    private String cnh;

    public Cliente(String nome, Long cpf, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public static Long getCpf(){
        return cpf;
    }

    public static Cliente procurarUsuario(Long cpf) {
        for (Cliente user : usuarios) {
            if (user.cpf.equals(cpf)){
                return user;
            }
        }
        return null;
    }

    public List<Veiculos> getVeiculos(){
        return Collections.unmodifiableList(meusVeiculos);
    }

    public static List<Cliente> getUsuarios(){
        return Collections.unmodifiableList(usuarios);
    }

    public static void addUsuario(Cliente usuario){
            usuarios.add(usuario);
    }

    public static Cliente verUsuarios() {
        for (Cliente user : usuarios) {
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

    public static Cliente Login(String nome, String senha)
            throws SenhaIncorretaException,
            UsuarioNaoEncontradoException {
        for(Cliente user : usuarios){
            if (user.nome.equals(nome)){
                if (user.senha.equals(senha)){
                    return user;
                }
                throw new SenhaIncorretaException();
            }
        }
        throw new UsuarioNaoEncontradoException(nome);
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void alterarUsuario(Cliente novoUsuario) {

    }

    public Cliente(String nome, Long cpf, String senha, String cnh) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + this.nome + '\'' +
                "cpf='" + this.cpf + '\'' +
                "senha='" + this.senha + '\'' +
                "cnh='" + this.cnh + '\'' +
                '}';
    }

    @Override
    public List<Veiculos> verAutomoveis(IBanco<Veiculos, String> banco) {
        return IBanco.buscarTodos();
    }

    @Override
    public List<Veiculos> verMeusAutomoveis() {
        return null;
    }

    @Override
    public Veiculos verAutomovel
            (String codigo, IBanco<Veiculos, String> banco)
            throws UsuarioNaoEncontradoException {
        return banco.buscarUm(codigo);
    }
}
