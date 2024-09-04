package com.example.demo.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientTypeTest {

    @Test
    @DisplayName("Teste de desconto para cliente VIP tem que ser 20%")
    void testeTipoClienteVipComDescontoDe20PorCento() {
        Cliente cliente = new Cliente(TipoCliente.VIP, 200.00);
        if (cliente.calculateDiscount(cliente.getPreco()) == cliente.getPreco() * 0.2) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("Teste de desconto para cliente Regular tem que ser 10%")
    void testeTipoClienteRegularComDescontoDe10PorCento() {
        Cliente cliente = new Cliente(TipoCliente.REGULAR, 300.00);
        if (cliente.calculateDiscount(cliente.getPreco()) == cliente.getPreco() * 0.1) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("Teste de desconto para cliente Sem Categoria não tem desconto")
    void testeTipoClienteSemCategoriaSemDesconto() {
        Cliente cliente = new Cliente(TipoCliente.SEM_CATEGORIA, 100.00);
        if (cliente.calculateDiscount(cliente.getPreco()) == 0.0) {
            assertTrue(true);
        } else {
            fail();
        }
    }
}
