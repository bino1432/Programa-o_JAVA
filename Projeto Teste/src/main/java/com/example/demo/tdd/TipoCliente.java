package com.example.demo.tdd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoCliente {

    VIP("Vip"),
    REGULAR("Regular"),
    SEM_CATEGORIA("Sem Categoria");

    private String tipoCliente;
}
