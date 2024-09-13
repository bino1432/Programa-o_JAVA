package com.spring.security.service;

import com.spring.security.entity.Usuario;
import com.spring.security.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;

    public void criarUsuario(Usuario usuario) {
        repository.save(usuario);
    }
}
