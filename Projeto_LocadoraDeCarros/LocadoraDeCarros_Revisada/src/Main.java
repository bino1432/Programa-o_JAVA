
import Usuario.*;

import java.util.Scanner;

import static Usuario.Usuario.Login;
import static Usuario.Usuario.getUsuarios;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente usuario = new Cliente("marcio", "345678", "123", "123");
        Gerente gerente = new Gerente("jean", "2638273", "456",1000);
        Vendedor vendedor = new Vendedor("nicholas", "1525153", "789", 1000);
        Usuario.addUsuario(usuario);
        Usuario.addUsuario(gerente);
        Usuario.addUsuario(vendedor);


        Usuario logado = logar();

            System.out.println("""
                       1 - ver meus veiculos
                       2 - sdadsada
                       3 - sadadasda
                    """);
            if(logado instanceof Vendedor) {
                System.out.println("""
                        4 - asdasd
                        5 - asdadasd
                        """);
                if (logado instanceof Gerente) {
                    System.out.println("""
                            nossa tu é gerente
                            """);
                }
            }

    }
    public static Usuario logar(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira seu nome:");
        String nome = sc.next();
        System.out.println("insira a sua senha:");
        String senha = sc.next();

        return Login(nome, senha);

    }
}