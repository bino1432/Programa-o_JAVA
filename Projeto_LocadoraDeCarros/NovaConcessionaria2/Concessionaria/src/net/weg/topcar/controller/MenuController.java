package net.weg.topcar.controller;

import net.weg.topcar.view.Entrada;
import net.weg.topcar.view.EntradaInteiro;
import net.weg.topcar.view.EntradaTexto;

public class MenuController {
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();

    private final Entrada<String> entradaTexto = new EntradaTexto();

    private final UsuarioController usuarioController = new UsuarioController(bancoUsuario, bancoAutomoveis);

    private final AutomovelController automovelController = new AutomovelController(bancoAutomovies );
    public void menuPrincipal() {
        do{
        Long escolha = entradaInteiro.leiaComSaida("""
                BeM Vindo ao Sistema!
                             
                1 - Cadastro
                2 - Login
                3 - Ver Automoveis
                4 - Ver Automovel
                0 - Sair
                """, saida);
        do {
            escolha = entradaInteiro.leia();
            acaoMenuPrincipal(escolha);
        } while (escolha < 0 || escolha > 4);
    }while (true);
    }

    public void acaoMenuPrincipal(Long escolha){
        switch (escolha){
            case 1 -> UsuarioController.cadastrarUsuario();
            case 2 -> Login();
            case 3 -> AutomovelController.verAutomoveis
            case 4 -> AutomovelController.verAutomoveis
            case 0 -> {
                saida.escrevaL("Obrigado por usar o" + "nosso sistema");
                System.exit(0);
            }
        }
    }
}
