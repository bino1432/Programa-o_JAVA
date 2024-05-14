package br.dev.cristopher;

public class CalculadoraComThreads {

    public void executarOperacoes() {
        System.out.println("Calculadora com Threads:");

        // Criando threads para executar operações matemáticas
        Thread threadAdicao = new Thread(new OperacaoAdicao(5, 3));
        Thread threadSubtracao = new Thread(new OperacaoSubtracao(10, 4));
        Thread threadMultiplicacao = new Thread(new OperacaoMultiplicacao(7, 8));
        Thread threadDivisao = new Thread(new OperacaoDivisao(20, 5));

        // Iniciando as threads
        threadAdicao.start();
        threadSubtracao.start();
        threadMultiplicacao.start();
        threadDivisao.start();

        // Aguardando as threads terminarem
        /*try {
            threadAdicao.join();
            threadSubtracao.join();
            threadMultiplicacao.join();
            threadDivisao.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}
