package net.weg.topcar.controller;


import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoCliente;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.AcessoNegadoException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.TipoDeUsuarioInvalidoException;
import net.weg.topcar.model.exceptions.UsuarioExistenteException;
import net.weg.topcar.model.usuarios.*;
import net.weg.topcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private static Cliente usuarioLogado;
    private final IBanco<Cliente, Long> bancoUsuarios = new BancoCliente();
    private final IBanco<Automovel, String> bancoAutomovel = new BancoAutomoveis();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    private final Entrada<String> entradaTexto = new EntradaTexto();

    private final Saida saida = new Saida();

    public void removerUsuario()  {
        if(usuarioLogado instanceof IGerente) {
            try {
                Long cpf = entradaCPF();
                bancoUsuarios.remover(cpf);
            } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
                saida.escrevaL(e.getMessage());
            }
        }
    }

    public void cadastroUsuario() {
        Long cpf = entradaCPF();
        try {
            validaCPF(cpf);
            String nome = entradaNome();
            Long idade = entradaIdade();
            String senha = entradaSenha();
            if (usuarioLogado instanceof Gerente) {
                Long escolha = selecionaTipoDeUsuario();
                if (escolha == 1) {
                    cadastroVendedor(nome, cpf, senha, idade);
                    return;
                }
            }
            cadastroCliente(nome, cpf, senha, idade);
        } catch (UsuarioExistenteException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    public Cliente buscarUsuario() throws ObjetoNaoEncontradoException {
        long cpf = entradaCPF();
        return bancoUsuarios.buscarUm(cpf);
    }

    public void verUsuario(){
        try {
            Cliente cliente = buscarUsuario();
            saida.escrevaL(cliente.toString());
        } catch (ObjetoNaoEncontradoException e){
            saida.escrevaL(e.getMessage());
        }
    }

    public void verVendedores(){
        List<Vendedor>listaVendedores = buscarVendedores();
        saida.escreva(listaVendedores.toString());
    }

    private List<Vendedor>filtrarVendedores(List<Cliente>listaClientes){
        List<Vendedor> listaVendedores = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente instanceof Vendedor vendedor) {
                listaVendedores.add(vendedor);
            }
        }
        return listaVendedores;
    }

    private List<Vendedor> buscarVendedores(){
        List<Cliente> listaClientes = bancoUsuarios.buscarTodos();
        List<Vendedor>listaVendedores = filtrarVendedores(listaClientes);
        return listaVendedores;
    }

    public void verClientes(){
        List<Cliente> clientes = bancoUsuarios.buscarTodos();
        saida.escreva(clientes.toString());
    }

    public void verPagamentoVendedores(){
        List<Vendedor>listaVendedores = buscarVendedores();
        for(Vendedor vendedor : listaVendedores){
            saida.escrevaL(vendedor.verPagamento());
        }
    }

    public void verPagamentoVendedor(){
        try {
            Cliente cliente = buscarUsuario();
            if(cliente instanceof IVendedor vendedor){
                saida.escrevaL(vendedor.verPagamento());
            } else {
                throw new TipoDeUsuarioInvalidoException(cliente);
            }
        } catch (ObjetoNaoEncontradoException | TipoDeUsuarioInvalidoException e){
            saida.escrevaL(e.getMessage());
        }
    }

    public void verPagamento(){
        if(usuarioLogado instanceof IVendedor vendedor){
            saida.escrevaL(vendedor.verPagamento());
        }
    }

    public void vender(){
        if(usuarioLogado instanceof IVendedor vendedor){
            saida.escrevaL("Identifique o comprador:");
            try{
                Cliente cliente = buscarUsuario();
                saida.escrevaL("Identifique o automóvel:");
                String codigo = entradaTexto.leiaComSaidaEValidacao("Código: ", saida);
                Automovel automovel = bancoAutomovel.buscarUm(codigo);
                vendedor.vender(automovel,cliente);
                bancoUsuarios.alterar(cliente.getCpf(), cliente);
                bancoAutomovel.alterar(codigo, automovel);

            }catch (ObjetoNaoEncontradoException e){
                saida.escrevaL(e.getMessage());
            }
        }
    }

    private void validaCPF(Long cpf) throws UsuarioExistenteException{
        if (bancoUsuarios.existe(cpf)) {
            throw new UsuarioExistenteException(cpf);
        }
    }

    private Long entradaCPF(){
        return entradaInteiro.leiaComSaidaEValidacao("CPF:", saida);
    }

    private String entradaNome(){
        return entradaTexto.leiaComSaidaEValidacao("Nome:", saida);
    }

    private Long entradaIdade(){
        return entradaInteiro.leiaComSaidaEValidacao("Idade:", saida);
    }

    private String entradaSenha(){
        String senha,confSenha;
        do {
            senha = entradaTexto.leiaComSaidaEValidacao("Senha:", saida);
            confSenha = entradaTexto.leiaComSaidaEValidacao("Confirme a senha:", saida);
        } while (senha.equals(confSenha));
        return senha;
    }

    private Double entradaSalario(){
        return entradaDecimal.leiaComSaidaEValidacao("Salário: ", saida);
    }

    private Long selecionaTipoDeUsuario(){
        return entradaInteiro.leiaComSaidaEValidacao("""
                        Qual o perfil de usuário você deseja cadastrar?
                        1 - Vendedor;
                        2 - Cliente.
                        """, saida);
    }

    private void cadastroCliente(String nome, Long cpf, String senha, Long idade) {
        bancoUsuarios.adicionar(new Cliente(nome, cpf, senha, idade));
    }

    private void cadastroVendedor(String nome, Long cpf, String senha, Long idade) {
        Double salario = entradaSalario();
        bancoUsuarios.adicionar(new Vendedor(nome, cpf, senha, idade, salario));
    }
}
