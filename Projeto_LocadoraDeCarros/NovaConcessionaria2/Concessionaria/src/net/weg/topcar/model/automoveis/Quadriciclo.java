package net.weg.topcar.model.automoveis;

public class Quadriciclo extends Automovel {
    public Quadriciclo(String CODIGO, String modelo, Long ano, String marca, String tipoCombustivel, double preco, double quilometragem, String placa, String cor, Boolean estado) {
        super(CODIGO, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado);
    }

    @Override
    public String toString() {
       return super.toString();
    }
}
