package net.weg.topcar.controller;


import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoUsuario;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.*;
import net.weg.topcar.model.usuarios.*;
import net.weg.topcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    Cliente cliente;
    String senha, confSenha, nome;
    Long cpf, idade, escolha;
    Double salario;
    private static Cliente usuarioLogado;
    private final BancoUsuario bancoUsuario = new BancoUsuario();
    private final BancoAutomoveis bancoAutomovel = new BancoAutomoveis();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Saida saida = new Saida();

    // Cliente
    public String cadastroUsuario() throws ObjetoNaoEncontradoException, UsuarioExistenteException {

        long cpf = entradaCpf();
        String nome = entradaNome();
        String senha = entradaSenha();
        long idade = entradaIdade();
        Double salario = cadastroSalario();
        Long escolha = selecioneTipoUsuario();
        validaCpf(cpf);

        if (usuarioLogado instanceof Gerente) {
            if (escolha == 1) {
                cadastroVendedor(nome, cpf, senha, idade);
                return "Vendedor cadastrado";
            }
        }
        cadastroCliente(nome, cpf, senha, idade);
        return "Vendedor cadastrado";
    }

    // Cliente
    public void verMeusAutomoveis() {
        List<Automovel> meusAutomoveis = usuarioLogado.verMeusAutomoveis();
        for (Automovel automovel : meusAutomoveis) {
            saida.escreval(automovel.toString());
        }
    }

    // Vendedor
    private Vendedor isVendedor() throws AcessoNegadoException {
        if (usuarioLogado instanceof Vendedor vendedor) {
            return vendedor;
        }
        throw new AcessoNegadoException("Usuario nao e um vendedor");
    }

    // Vendedor
    public void verUsuario() {
        try {
            isVendedor();
            Cliente cliente = buscarUsuario();
            saida.escreval(cliente.toString());
        } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    // Vendedor
    public void verPagemento() {
        try {
            Vendedor vendedor = (Vendedor) isVendedor();
            saida.escreval(vendedor.verPagamento());
            saida.escreval(vendedor.verPagamento());
        } catch (AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    // Vendedor
    public void vender() {
        if (usuarioLogado instanceof Vendedor vendedor) {
            saida.escreval("Identifique o comprador.");
            try {
                isVendedor();
                Cliente cliente = buscarUsuario();
                saida.escreval("Identifique o automovel.");
                Automovel automovel = buscarAutomovel();
                vendedor.vender(automovel, cliente);
                atualizarEnvolvidosNaVenda(cliente, vendedor, automovel);
            } catch (ObjetoNaoEncontradoException | FalhaNaCompraException | AcessoNegadoException e) {
                saida.escreval(e.getMessage());
            }
        }
    }

    // Gerente
    public void verClientes() {
        try {
            isGerente();
            List<Cliente> listaClientes = bancoUsuario.buscarTodos();
            saida.escreva(listaClientes.toString());
        } catch (AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }

    }

    // Gerente
    public void verPagamentoVendedor() throws ObjetoNaoEncontradoException {
        try {
            isGerente();
            Cliente cliente = buscarUsuario();
            if (cliente instanceof IVendedor vendedor) {
                saida.escreval(vendedor.verPagamento());
            } else {
                throw new TipoUsuarioInvalidoException(cliente);
            }
        } catch (ObjetoNaoEncontradoException | TipoUsuarioInvalidoException | AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }

    }

    // Gerente
    public void editarUsuario() {
        try {
            isGerente();
            Cliente cliente = buscarUsuario();
            if (!(cliente instanceof Gerente)) {
                nome = entradaNome();
                idade = entradaIdade();
                if (cliente instanceof Vendedor vendedor) {
                    salario = cadastroSalario();
                    bancoUsuario.alterar(cliente.getCpf().toString(), new Vendedor(nome, cliente.getCpf(), cliente.getSenha(), idade, salario));
                } else {
                    bancoUsuario.alterar(cliente.getCpf().toString(), new Cliente(nome, cliente.getCpf(), cliente.getSenha(), idade));
                }
            }
        } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    // Gerente
    public void verPagamentoVendedores() {
        try {
            isGerente();
            List<Vendedor> listaVendedores = buscarVendedores();

            for (Vendedor vendedor : listaVendedores) {
                saida.escreval(vendedor.verPagamentoComNome());
            }
        } catch (AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    // Gerente
    public void removerUsuario() {
        try {
            isGerente();
            long cpf = entradaCpf();
            bancoUsuario.remover(String.valueOf(cpf));
        } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    // Gerente
    public void verVendedore() {
        try {
            isGerente();
            List<Vendedor> listaVendedores = buscarVendedores();
            saida.escreva(listaVendedores.toString());
        } catch (AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    // Gerente
    private void isGerente() throws AcessoNegadoException {
        if (!(usuarioLogado instanceof IGerente)) {
            throw new AcessoNegadoException("Usuario nao é um gerente");
        }
    }


    private List<Vendedor> filtrarVendedores(List<Cliente> listaClientes) {
        List<Vendedor> listaVendedores = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente instanceof Vendedor vendedor) {
                listaVendedores.add(vendedor);
            }
        }
        return listaVendedores;
    }

    private List<Vendedor> buscarVendedores() {
        List<Cliente> listaClientes = bancoUsuario.buscarTodos();
        return filtrarVendedores(listaClientes);
    }

    private Cliente buscarUsuario() throws ObjetoNaoEncontradoException {
        cpf = entradaCpf();
        return bancoUsuario.buscarUm(String.valueOf(cpf));
    }

    private Automovel buscarAutomovel() throws ObjetoNaoEncontradoException {
        String codigo = entradaCodigo();
        return bancoAutomovel.buscarUm(codigo);
    }

    private String entradaCodigo() {
        return entradaTexto.leiaComSaidaEValidacao("Codigo", saida);
    }

    private void atualizarEnvolvidosNaVenda(Cliente cliente, Vendedor vendedor, Automovel automovel) throws ObjetoNaoEncontradoException {
        bancoUsuario.alterar(vendedor.getCpf().toString(), cliente);
        bancoUsuario.alterar(cliente.getCpf().toString(), cliente);
        bancoAutomovel.alterar(automovel.getCODIGO(), automovel);
    }

    private void validaCpf(Long cpf) throws UsuarioExistenteException {
        if (bancoUsuario.existe(String.valueOf(cpf))) {
            throw new UsuarioExistenteException();
        }
    }

    private long entradaCpf() {
        return cpf = entradaInteiro.leiaComSaidaEValidacao("CPF:", saida);
    }

    private String entradaNome() {
        String novoNome = entradaTexto.leiaComSaida("Nome: ", saida);
        if (novoNome.isEmpty()) {
            novoNome = nome;
        }
        return novoNome;
    }

    private String entradaSenha() {
        do {
            senha = entradaTexto.leiaComSaidaEValidacao("Senha:", saida);
            confSenha = entradaTexto.leiaComSaidaEValidacao("Confirme a senha:", saida);
        } while (!senha.equals(confSenha));
        return null;
    }

    private long entradaIdade() {
        long novaIdade = entradaInteiro.leiaComSaida("Idade: ", saida);
        if (novaIdade > 0) {
            novaIdade = idade;
        }
        return novaIdade;
    }

    private Double cadastroSalario() {
        Double novoSalario = entradaDecimal.leiaComSaida("Salario: ", saida);
        if (novoSalario <= 0.0) {
            novoSalario = salario;
        }
        return novoSalario;
    }

    private Long selecioneTipoUsuario() {
        escolha = entradaInteiro.leiaComSaidaEValidacao("""
                Qual o perfil de usuário você deseja cadastrar?
                1 - Vendedor;
                Outro - Cliente.
                """, saida);


        return selecioneTipoUsuario();
    }

    private String cadastroVendedor(String nome, Long cpf, String senha, Long idade) {
        bancoUsuario.adicionar(new Vendedor(nome, cpf, senha, idade, salario));
        return "Usuario" + nome + " cadastrado com sucesso";
    }

    private String cadastroCliente(String nome, Long cpf, String senha, Long idade) {
        cliente = new Vendedor(nome, cpf, senha, idade, salario);
        bancoUsuario.adicionar(cliente);
        return "Usuario" + nome + " cadastrado com sucesso";
    }


}
