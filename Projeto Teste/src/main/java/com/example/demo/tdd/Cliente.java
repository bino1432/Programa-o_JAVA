package com.example.demo.tdd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    private TipoCliente tipoCliente;
    private Double preco;

    public Double calculateDiscount(Double preco) {
        switch (tipoCliente) {
            case VIP:
                return preco * 0.2;
            case REGULAR:
                return preco * 0.1;
            default:
                return 0.0;
        }
    }
}
