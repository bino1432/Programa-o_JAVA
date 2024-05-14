package br.dev.cristopher;

public class OperacaoMultiplicacao implements Runnable {

    private int a;
    private int b;

    public OperacaoMultiplicacao(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println("Resultado da multiplicação: " + (a * b));
    }

}
