package br.dev.cristopher;

class OperacaoDivisao implements Runnable {

    private int a;
    private int b;

    public OperacaoDivisao(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        if (b == 0) {
            System.out.println("Não é possível dividir por zero.");
            return;
        }
        System.out.println("Resultado da divisão: " + (a / b));
    }

}
