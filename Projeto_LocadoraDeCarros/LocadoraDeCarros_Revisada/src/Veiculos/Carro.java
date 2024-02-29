package Veiculos;

public class Carro extends Veiculos{
    public Carro(String codigo, float preco, String marca, String placa, boolean novo, String status, int quilometragem, String modelo, int ano) {
        super(codigo, preco, marca, placa, novo, status, quilometragem, modelo, ano);
    }

    @Override
    public String toString() {
        return "Carro{}";
    }
}
