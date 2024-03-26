package net.weg.topcar.controller;


import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoCliente;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.*;
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
            String nome = entradaNome("marcos");
            Long idade = entradaIdade(12L);
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

    private String entradaCodigo(){
        return entradaTexto.leiaComSaidaEValidacao("Codigo: ", saida);
    }

    private Automovel buscarAutomovel() throws ObjetoNaoEncontradoException {
        String codigo = entradaCodigo();
        return bancoAutomovel.buscarUm(codigo);
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

    public void verPagamentoVendedores() {
        List<Vendedor> listaVendedores = buscarVendedores();
        for (Vendedor vendedor : listaVendedores) {
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

    private void atualizarEnvolvidosNaVenda(Cliente cliente,
                                            Vendedor vendedor,
                                            Gerente Gerente){}


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
                bancoUsuarios.alterar(vendedor.getCpf(), (Cliente) vendedor);
                bancoAutomovel.alterar(codigo, automovel);

            }catch (ObjetoNaoEncontradoException |
                    FalhaNaCompraException e){
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

    private String entradaNome(String nome){
        String novoNome = entradaTexto.leiaComSaida("Nome: ", saida);
        if (novoNome.isEmpty()){
            novoNome = nome;
        }
        return novoNome;
    }

    private Long entradaIdade(Long idade){
        Long novaIdade = entradaInteiro.leiaComSaida("Idade: ", saida);
        if (novaIdade == 0){
            novaIdade = idade;
        }
        return novaIdade;
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

    private void cadastroVendedor(String nome, Long cpf, String senha, Long idade, Double salario) {
        bancoUsuarios.adicionar(new Vendedor(nome, cpf, senha, idade, salario));
    }

    private Vendedor isVendedor(){
        if(usuarioLogado instanceof Vendedor vendedor) {
            return vendedor;
        }
        return null;
    }
}
