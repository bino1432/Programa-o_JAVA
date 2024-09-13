package com.spring.security.security.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
        @NotBlank
        String usuario,
        @NotBlank
        String senha
) {
}
