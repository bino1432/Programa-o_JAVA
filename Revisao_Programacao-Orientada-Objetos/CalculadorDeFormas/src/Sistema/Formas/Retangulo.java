package Sistema.Formas;

public class Retangulo extends Formas{

    private int lado1;
    private int lado2;

    public Retangulo(int lado1, int lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public int calcularArea(int lado1, int lado2){
        return lado1 * lado2;
    }

    public int calcularPerimetro(int lado1, int lado2){
        return 2 * (lado1 + lado2);
    }
}
