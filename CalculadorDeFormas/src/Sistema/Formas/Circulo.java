package Sistema.Formas;

public class Circulo extends Formas{

    private int raio;

    public Circulo(int raio){
        this.raio = raio;
    }

    public double calcularArea(int raio){
        return Math.PI * (Math.pow(raio, 2));
    }

    public double calcularPerimetro(int raio){
        return Math.PI * 2 * raio;
    }

    public int calcularDiametro(int raio){
        return raio * 2;
    }
}
