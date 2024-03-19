package net.weg.TopCar.controller;

import net.weg.TopCar.view.*;

public class UsuarioController {
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Saida saida = new Saida();
    public void cadastroUsuario(){
        String nome = entradaTexto.leia("Informe o seu nome: ",saida);
        Long cpf = entradaInteiro.leia("Informe o seu cpf ", saida);
        String senha = entradaTexto.leia("Informe a sua senha: ",saida);
        String confSenha = entradaTexto.leia("Confirme a sua senha: ",saida);

        
    }
}
