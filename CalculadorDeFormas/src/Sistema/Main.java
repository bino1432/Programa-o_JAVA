package Sistema;

import Sistema.Formas.Circulo;
import Sistema.Formas.Formas;
import Sistema.Formas.Quadrado;
import Sistema.Formas.Retangulo;
import Sistema.Formas.Triangulo.Equilatero;
import Sistema.Formas.Triangulo.Escaleno;
import Sistema.Formas.Triangulo.Isoceles;
import Sistema.Formas.Triangulo.Triangulo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int tentativas = 1;
        boolean logado = false;

        Professor professor = new Professor("senai");
        Scanner sc = new Scanner(System.in);

        while (logado == false){
            System.out.println("Insira a sua senha:");
            if(professor.login(sc.next())){
                System.out.println("Logado com sucesso!");
                logado = true;
            } else if(tentativas == 3){
                System.out.println("Senha incorreta");
                System.exit(0);
            } else {
                tentativas++;
            }
        }
        while(Escolha(sc.nextInt()) != 6){
            System.out.println("Bem vindo ao calculador de Formas!");
            System.out.println("1 - Calcular Quadrado");
            System.out.println("2 - Calcular Retangulo");
            System.out.println("3 - Calcular Triangulo");
            System.out.println("4 - Calcular Circulo");
            System.out.println("5 - Listar Formas");
            System.out.println("6 - LogOut");
            System.out.println("Escolha oque deseja fazer:");
        }
    }

    public static int Escolha(int escolha){

        Scanner sc = new Scanner(System.in);
        boolean correto = false;
        boolean corretoT = false;
        int lado1;
        int lado2;
        int ladoT1;
        int ladoT2;
        int ladoT3;

        switch (escolha){
            case 1:
                System.out.println("Escolha o Lado do Quadrado:");
                Quadrado quadrado = new Quadrado(sc.nextInt());
                Formas.addForma(quadrado);
                System.out.println("Tamanho de lado salvo!");
                break;
            case 2:
                while(correto = false){
                    correto = false;
                    System.out.println("Escolha o primeiro Lado do Retangulo:");
                    lado1 = sc.nextInt();
                    System.out.println("Escolha o segundo Lado do Retangulo:");
                    lado2 = sc.nextInt();
                    if(lado1 <= 0 || lado2 <= 0){
                        System.out.println("O lado não pode ser 0 ou negativo");
                    } else if (lado1 == lado2){
                        System.out.println("Os lados não podem ser iguais");
                    } else {
                        Retangulo retangulo = new Retangulo(lado1, lado2);
                        Formas.addForma(retangulo);
                        System.out.println("Tamanho dos lados salvos!");
                    }
                }
                break;
            case 3:
                while (corretoT = false) {
                    corretoT = false;
                    System.out.println("Escolha o primeiro Lado do Triangulo:");
                    ladoT1 = sc.nextInt();
                    System.out.println("Escolha o Segundo Lado do Triangulo:");
                    ladoT2 = sc.nextInt();
                    System.out.println("Escolha o Terceiro Lado do Triangulo:");
                    ladoT3 = sc.nextInt();
                    if(ladoT1 <= 0 || ladoT2 <= 0 || ladoT3 <= 0 ){
                        System.out.println("O lado não pode ser 0 ou negativo");
                    } else {
                        Isoceles isoceles = new Isoceles(ladoT1, ladoT2, ladoT3);
                        Escaleno escaleno = new Escaleno(ladoT1, ladoT2, ladoT3);
                        Equilatero equilatero = new Equilatero(ladoT1, ladoT2, ladoT3);
                        Formas.addForma(isoceles);
                        Formas.addForma(escaleno);
                        Formas.addForma(equilatero);
                    }
                }
                break;
            case 4:
                System.out.println("Escolha o Raio do Circulo:");
                Circulo circulo = new Circulo(sc.nextInt());
                Formas.addForma(circulo);
                System.out.println("Tamanho do raio salvo!");
                break;
            case 5:
                System.out.println("Listando Formas");
                break;
            case 6:
                System.out.println("LogOut...");
                break;
            default:
                System.out.println("Escolha Invalida!");
        }
        return escolha;
    }
}
