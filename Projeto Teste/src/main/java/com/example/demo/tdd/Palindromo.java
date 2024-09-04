package com.example.demo.tdd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Palindromo {

    private String palindromo;

    public boolean isPalindrome(String palindromo) {
        String palavra = palindromo.toLowerCase();
        int tamanho = palavra.length();
        for (int contador = 0; contador < tamanho; contador++) {
            if (palavra.charAt(contador) != palavra.charAt(tamanho - (contador + 1))) {
                return false;
            }
        }
        return true;
    }
}
