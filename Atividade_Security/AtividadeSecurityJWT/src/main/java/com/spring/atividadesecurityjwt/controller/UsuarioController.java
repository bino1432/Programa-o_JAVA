package com.spring.atividadesecurityjwt.controller;

import com.spring.atividadesecurityjwt.entity.Usuario;
import com.spring.atividadesecurityjwt.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService service;

    @PreAuthorize("permitAll()")
    @GetMapping()
    public ResponseEntity<?> listarUsuarios() {
        System.out.println("Listando usuários");
        return ResponseEntity.ok(service.listarUsuarios());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/detalhes")
    public ResponseEntity<?> usuarioLogado() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/senha")
    public ResponseEntity<?> alterarSenha(
            @AuthenticationPrincipal Usuario usuario,
            @RequestBody String senha) {
        return ResponseEntity.ok(service.alterarSenha(usuario, senha));
    }

    @PreAuthorize("hasAuthority('FUNCIONARIO')")
    @PutMapping("/{idUser}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long idUser, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.editarUsuario(idUser, usuario));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping()
    public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario) {
        service.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

}
