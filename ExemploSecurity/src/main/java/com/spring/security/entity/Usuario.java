package com.spring.security.entity;

import com.spring.security.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Classe de entidade que representa um Usuario.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario implements UserDetails {

    /**
     * Identificador único para o Usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome de usuário do Usuario.
     */
    private String usuario;

    /**
     * Nome do Usuario.
     */
    private String nome;

    /**
     * Senha do Usuario.
     */
    private String senha;

    /**
     * Email do Usuario.
     */
    private String email;

    /**
     * Perfil/role do Usuario.
     */

//    private boolean habilitado;
//
//    private boolean senhaNaoExpirada;
    private Perfil perfil;

//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.senhaNaoExpirada;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.habilitado;
//    }

    /**
     * Retorna as autoridades concedidas ao Usuario.
     *
     * @return uma coleção de autoridades concedidas
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(perfil);
    }

    /**
     * Retorna a senha usada para autenticar o Usuario.
     *
     * @return a senha
     */
    @Override
    public String getPassword() {
        return this.senha;
    }

    /**
     * Retorna o nome de usuário usado para autenticar o Usuario.
     *
     * @return o nome de usuário
     */
    @Override
    public String getUsername() {
        return this.usuario;
    }
}