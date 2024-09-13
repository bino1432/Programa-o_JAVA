package com.spring.security.controller;

import com.spring.security.entity.Usuario;
import com.spring.security.enums.Perfil;
import com.spring.security.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para gerenciar entidades de Usuario.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service;

    /**
     * Cria um novo Usuario.
     *
     * @param usuario a entidade Usuario a ser criada
     * @return um ResponseEntity indicando o resultado da operação
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        service.criarUsuario(usuario);
        return ResponseEntity.ok().build();
    }
}