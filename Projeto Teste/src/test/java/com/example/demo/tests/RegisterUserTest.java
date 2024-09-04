package com.example.demo.tests;

import com.example.demo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterUserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Testando Email inválido")
    void TesteEmailValido() {
        if (userService.isEmailValid("emailInvalido")) {
            fail();
        } else {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Testando senha inválida")
    void TesteSenhaValida() {
        String emailCerto = "email@gmail.com";
        if (userService.registerUser(emailCerto, "1234567")) {
            fail();
        } else {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Testando registro de usuário correto")
    void TesteRegistroDeUsuarioCorreto() {
        String emailCerto = "email@gmail.com";
        String senhaCorreta = "123456789";
        boolean teste = userService.registerUser(emailCerto, senhaCorreta);
        if (teste) {
            assertTrue(true);
            System.out.println(teste);
        } else {
            System.out.println(teste);
            fail();
        }
    }
}
