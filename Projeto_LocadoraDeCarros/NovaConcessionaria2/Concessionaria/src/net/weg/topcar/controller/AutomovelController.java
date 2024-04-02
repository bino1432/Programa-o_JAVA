package net.weg.topcar.controller;

import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoUsuario;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.exceptions.AcessoNegadoException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.IGerente;
import net.weg.topcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class AutomovelController {

    String codigo;
    double preco;
    private static Cliente usuarioLogado;
    private final BancoUsuario bancoUsuario = new BancoUsuario();
    private final BancoAutomoveis bancoAutomovel = new BancoAutomoveis();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Saida saida = new Saida();

    public void verAutomoveis(){
        List<Automovel> listaAutomovel = bancoAutomovel.buscarTodos();
        List<Automovel> listaAutomoveisDisponiveis = filtrarAutomoveisDisponiveis(listaAutomovel);
        for (Automovel automovel : listaAutomoveisDisponiveis) {
            saida.escreval(automovel.toString());
        }
    }

    private List<Automovel> filtrarAutomoveisDisponiveis(List<Automovel> listaAutomoveis) {
        List<Automovel> listaAutomoveisDisponiveis = new ArrayList<>();
        for (Automovel automovel : listaAutomoveis) {
            if (!automovel.isComprado()) {
                listaAutomoveisDisponiveis.add(automovel);
            }
        }
        return listaAutomoveisDisponiveis;
    }

    public void verAutomovel() {
        try {
            Automovel automovel = bancoAutomovel.buscarUm(codigo);
            saida.escreval(automovel.toString());
        } catch (ObjetoNaoEncontradoException e) {
            saida.escreval(e.getMessage());
        }

    }

    public void removerAutomovel() {
        try {
            isGerente();
            codigo = entradaCodigo();
            bancoAutomovel.remover(codigo);
        } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    public void alterarPreco() {
        try {
            isGerente();
            codigo = entradaCodigo();
            Automovel automovel = bancoAutomovel.buscarUm(codigo);
            preco = entradaPreco(automovel.getPreco());
            automovel.setPreco(preco);
            bancoAutomovel.alterar(automovel.getCODIGO(), automovel);
        } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
            saida.escreval(e.getMessage());
        }
    }

    public void cadastroAutomovel(){
        try {
            isGerente();
            codigo = entradaCodigo();
            validarCodigo();

            String modelo = entradaModelo();
            String marca = entradaMarca();
            String tipoCombustivel = entradaTipoCombustivel();
            String placa = entradaPlaca();
            String cor = entradaCor();
            Long ano = entradaAno();
            double preco = entradaPreco();
            double quilometragem = entradaQuilometragem();
            boolean novo = entradanovo();
            Long tipo = selecioneAutomovel();

            if (tipo == 1) {
                String carroceria = entradaTipoCarroceria();
                String marcha = entradaMarcha();
                cadastroCarro(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, marcha, carroceria);
            } else if (tipo == 2) {
                Long cilindradas = entradaCilindradas();
                String partida = entradaPartida();
                cadastroMoto(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, partida, cilindradas);
            } else {

            }

        }catch (AcessoNegadoException | VeiculoExistenteException e) {
            saida.escreval(e.getMessage());
        }
    }

    private Long selecioneAutomovel() {
        Long entrada;
        do {
            entrada = entradaInteiro.leiaComSaidaEValidacao("""
                Qual o tipo de Automovel?
                1 - Carro;
                2 - Moto;
                3 - Quadriciclo.
                """, saida);
        } while (entrada>2);
        return entrada;

    }

    private void cadastroCarro(String codigo, String modelo, Long ano, String marca, String tipoCombustivel, double preco, Double quilometragem, String placa, String cor, Boolean novo, String marcha, String carroceria) {
        Carro carro = new Carro(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, marcha, carroceria);
        bancoAutomovel.adicionar(carro);
    }

    private void cadastroMoto(String codigo, String modelo, Long ano, String marca, String tipoCombustivel, double preco, double quilometragem, String placa, String cor, Boolean novo, String partida, long cilindradas) {
        Moto moto = new Moto(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, partida, cilindradas);
        bancoAutomovel.adicionar(moto);
    }

    private void validarCodigo() throws VeiculoExistenteException {
        if (bancoAutomovel.existe(codigo)) {
            throw new VeiculoExistenteException(codigo);
        }
    }

    private String entradaMarca() {
        return entradaTexto.leiaComSaidaEValidacao("Marca: ", saida);
    }

    private String entradaModelo() {
        return entradaTexto.leiaComSaidaEValidacao("Modelo: ", saida);
    }

    private String entradaPlaca() {
        return entradaTexto.leiaComSaidaEValidacao("Placa: ", saida);
    }

    private String entradaCor() {
        return entradaTexto.leiaComSaidaEValidacao("Cor: ", saida);
    }

    private String entradaTipoCombustivel() {
        return entradaTexto.leiaComSaidaEValidacao("Combustivel: ", saida);
    }

    private String entradaMarcha() {
        return entradaTexto.leiaComSaidaEValidacao("Marcha: ", saida);
    }

    private String entradaPartida() {
        return entradaTexto.leiaComSaidaEValidacao("Partida: ", saida);
    }

    private String entradaTipoCarroceria() {
        return entradaTexto.leiaComSaidaEValidacao("Carroceria: ", saida);
    }

    private Double entradaQuilometragem() {
        return entradaDecimal.leiaComSaidaEValidacao("Quilometragem: ", saida);
    }

    private Double entradaPreco() {
        return entradaDecimal.leiaComSaidaEValidacao("Preco: ", saida);
    }

    private Long entradaAno() {
        return entradaInteiro.leiaComSaidaEValidacao("Ano: ", saida);
    }

    private Long entradaCilindradas() {
        return entradaInteiro.leiaComSaidaEValidacao("Cilindradas: ", saida);
    }

    private Boolean entradanovo() {
        Long entrada;
        do {
           entrada = entradaInteiro.leiaComSaidaEValidacao("""
                Carro 0 km?
                1 - Sim
                2 - nao
                """, saida);
        } while (entrada>2);
        return entrada == 1;
    }

    private Double entradaPreco(Double precoAntigo) {
        Double novoPreco = entradaDecimal.leiaComSaida("Preco: ",saida);
        if (novoPreco <= 0 ) {
            return precoAntigo;
        } return novoPreco;
    }

    private void isGerente() throws AcessoNegadoException {
        if (!(usuarioLogado instanceof IGerente)){
            throw new AcessoNegadoException("Usuario nao é um gerente");
        }
    }

    private String entradaCodigo() {
        return entradaTexto.leiaComSaidaEValidacao("Código: ", saida);
    }

    private Boolean entradaNovo() {
        Long entrada;
        do {
            entrada = entradaInteiro.leiaComSaida("""
                    Automovel 0km?
                    1 - Sim
                    2 - Não
                    """, saida);
        } while(entrada > 2);
        return entrada == 1;
    }
    private void editarVeiculo() {
        try {
            bancoAutomovel.alterar(codigo, automovelEditado);
        }
    }
}
