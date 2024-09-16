package com.spring.security.entity.cenario_3;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Data
public class UsuarioCenarioTres implements UserDetails {

    private final PessoaCenarioTres pessoa;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(UsuarioCenarioTres.class.getSimpleName()));
    }

    @Override
    public String getPassword() {
        return this.pessoa.getSenha();
    }

    @Override
    public String getUsername() {
        return this.pessoa.getUsuario();
    }
}
