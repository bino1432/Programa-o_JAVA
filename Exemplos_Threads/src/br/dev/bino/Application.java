package br.dev.cristopher;

public class Application {

    public static void main(String[] args) {
        // Criando uma calculadora simples sem o uso de threads
        CalculadoraSemThreads calculadoraSemThreads = new CalculadoraSemThreads();

        // Testando a calculadora sem threads
        calculadoraSemThreads.executarOperacoes();

        // Criando uma calculadora com o uso de threads
        CalculadoraComThreads calculadoraComThreads = new CalculadoraComThreads();

        // Testando a calculadora com threads
        calculadoraComThreads.executarOperacoes();
    }

}
