package com.spring.security.repository;

import com.spring.security.entity.Usuario;
import com.spring.security.entity.cenario_2.UsuarioCenarioDois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String username);
    Optional<Usuario> findByEmail(String email);
}
