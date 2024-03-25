package net.weg.topcar.model.automoveis;

public class Quadriciclo extends Automovel {
    public Quadriciclo(String CODIGO, String modelo, int ano, String marca, String tipoCombustivel, double preco, int quilometragem, String placa, String cor, String estado) {
        super(CODIGO, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado);
    }

    @Override
    public String toString() {
       return super.toString();
    }
}
