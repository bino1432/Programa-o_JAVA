package net.weg.topcar.model.automoveis;

public class Carro extends Automovel {
    private String marcha;
    private String carroceria;

    public Carro(String CODIGO, String modelo, Long ano, String marca, String tipoCombustivel, double preco, Double quilometragem, String placa, String cor, Boolean novo, String marcha, String tipoCarroceria) {
        super(CODIGO, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo);
        this.marcha = marcha;
        this.carroceria = tipoCarroceria;
    }

    public String getMarcha() {
        return marcha;
    }

    public String getTipoCarroceria() {
        return carroceria;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMarcha: " + marcha +
                "\nTipo da carroceria: " + carroceria;
    }
}
