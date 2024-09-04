package com.example.demo.tests;

import com.example.demo.model.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class CalculatorTests {

    @Test
    @DisplayName("Teste se o método add está somando os números")
    void TesteSeOMetodoAddEstaSomandoOsNumeros() {
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 1;
        if (calculator.add(a, b) == a + b) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("Teste se o método subtract está subtraindo os números")
    void TesteSeOMetodoSubtractEstaSubtraindoOsNumeros() {
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 1;
        if (calculator.subtract(a, b) == a - b) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("Teste se o método multiply está multiplicando os números")
    void TesteSeOMetodoMultiplyEstaMultiplicandoOsNumeros() {
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 2;
        if (calculator.multiply(a, b) == a * b) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("Teste se o método divide B não pode ser 0")
    void TesteSeOMetodoDivideBNaoPodeSerZero() {
        try {
            Calculator calculator = new Calculator();
            int a = 2;
            int b = 0;
            calculator.divide(a, b);
            fail();
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Teste se o método divide está dividindo os números")
    void TesteSeOMetodoDivideEstaDividindoOsNumeros() {
        try {
            Calculator calculator = new Calculator();
            int a = 2;
            int b = 2;
            calculator.divide(a, b);
            assertTrue(true);
        } catch (ArithmeticException e) {
            fail();
        }
    }
}
