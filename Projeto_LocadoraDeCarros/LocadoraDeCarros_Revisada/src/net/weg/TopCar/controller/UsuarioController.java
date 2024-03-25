package net.weg.TopCar.controller;

import net.weg.TopCar.model.usuario.Cliente;
import net.weg.TopCar.view.*;

public class UsuarioController {

    private static Cliente usuarioLogado;

    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Saida saida = new Saida();
    public void cadastroUsuario(){
        String nome = entradaTexto.leiaComSaida("Informe o seu nome: ",saida);
        Long cpf = entradaInteiro.leiaComSaida("Informe o seu cpf ", saida);
        String senha = entradaTexto.leiaComSaida("Informe a sua senha: ",saida);
        String cnh = entradaTexto.leiaComSaida("Informe o seu cnh: ",saida);

        if (usuarioLogado == null){
            Cliente cliente = new Cliente(nome, cpf, senha, cnh);
        }
    }
}