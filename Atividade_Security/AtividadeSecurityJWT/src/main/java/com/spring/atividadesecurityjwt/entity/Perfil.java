package com.spring.atividadesecurityjwt.entity;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public enum Perfil implements GrantedAuthority {
    ADMIN("Administrador"),
    FUNCIONARIO("Funcionário"),
    CLIENTE("Cliente");

    private final String nome;

    @Override
    public String getAuthority() {
        return this.name();
    }

}
