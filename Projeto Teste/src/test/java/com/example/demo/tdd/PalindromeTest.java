package com.example.demo.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PalindromeTest {

    @Test
    @DisplayName("Teste de se palavra não é Palindromo")
    void testSeAPalabraNaoEPalindromo() {
        Palindromo palindrome = new Palindromo();
        if (palindrome.isPalindrome("casa")) {
            fail();
        } else {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Teste de se palavra é Palindromo")
    void testSeAPalabraEPalindromo() {
        Palindromo palindrome = new Palindromo();
        if (palindrome.isPalindrome("radar")) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("Teste de se palavra vazia é Palindromo")
    void testSeAPalabraVaziaEPalindromo() {
        Palindromo palindrome = new Palindromo();
        if (palindrome.isPalindrome("")) {
            assertTrue(true);
        } else {
            fail();
        }
    }
}
