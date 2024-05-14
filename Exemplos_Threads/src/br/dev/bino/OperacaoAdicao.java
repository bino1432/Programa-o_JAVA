package br.dev.cristopher;

public class OperacaoAdicao implements Runnable {

    private int a;
    private int b;

    public OperacaoAdicao(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Resultado da adição: " + (a + b));
    }

}