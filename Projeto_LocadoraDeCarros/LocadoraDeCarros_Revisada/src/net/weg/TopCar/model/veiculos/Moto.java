package net.weg.TopCar.model.veiculos;

public class Moto extends Veiculos {
    public Moto(Long codigo, float preco, String marca, String placa, boolean novo, String status, int quilometragem, String modelo, int ano) {
        super(codigo, preco, marca, placa, novo, status, quilometragem, modelo, ano);
    }

    @Override
    public String toString() {
        return "Moto{}";
    }
}
