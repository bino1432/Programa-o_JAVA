package com.spring.atividadesecurityjwt.security.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String username,
        @NotBlank
        String senha

) {
}
