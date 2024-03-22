package net.weg.TopCar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Entrada<T> {
    protected final Scanner sc = new Scanner(System.in);

    protected abstract boolean validacaoEntrada(T valor);
    public abstract T leia() throws InputMismatchException;

    public T leiaComSaida(String texto, Saida saida) throws InputMismatchException{
        saida.escreva(texto);
        return leia();
    }

    public T leiaComValidacao() {
        T valor;
        do {
            valor = leia();
        } while (!validacaoEntrada(valor));
        return valor;
    }

    public T leiaComSaidaValidacao(String mensagem, Saida saida) {
        T valor;
        do {
            valor = leiaComSaida(mensagem, saida);
        } while (!validacaoEntrada(valor));
        return valor;
    }
}