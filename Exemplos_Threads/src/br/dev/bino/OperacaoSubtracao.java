package br.dev.cristopher;

class OperacaoSubtracao implements Runnable {

    private int a;
    private int b;

    public OperacaoSubtracao(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println("Resultado da subtração: " + (a - b));
    }

}
