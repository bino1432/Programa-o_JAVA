package br.dev.cristopher;

public class CalculadoraSemThreads {

    public void executarOperacoes() {
        System.out.println("Calculadora sem Threads:");

        System.out.println("Resultado da adição: " + adicionar(5, 3));
        System.out.println("Resultado da subtração: " + subtrair(10, 4));
        System.out.println("Resultado da multiplicação: " + multiplicar(7, 8));
        System.out.println("Resultado da divisão: " + dividir(20, 5));
    }

    private int adicionar(int a, int b) {
        return a + b;
    }

    private int subtrair(int a, int b) {
        return a - b;
    }

    private int multiplicar(int a, int b) {
        return a * b;
    }

    private int dividir(int a, int b) {
        if (b == 0) {
            System.out.println("Não é possível dividir por zero.");
            return 0;
        }
        return a / b;
    }

}
