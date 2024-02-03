package Sistema.Formas;

public class Quadrado extends Formas{

    private int lado;

    public Quadrado(int lado){
        this.lado = lado;
    }

    public double calcularArea(int lado){
        return Math.pow(lado, 2);
    }

    public double calcularPerimetro(int lado){
        return lado * 4;
    }
}
