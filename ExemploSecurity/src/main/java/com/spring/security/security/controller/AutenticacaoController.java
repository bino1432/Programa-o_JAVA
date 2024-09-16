package com.spring.security.security.controller;

import com.spring.security.entity.Usuario;
import com.spring.security.security.controller.dto.LoginDTO;
import com.spring.security.security.utils.CookieUtils;
import com.spring.security.security.utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para lidar com requisições de autenticação.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AutenticacaoController {

    private AuthenticationProvider authenticationProvider;
    private SecurityContextRepository securityContextRepository;

    private JwtUtils jwtUtils;
    private CookieUtils cookieUtils;
    /**
     * Lida com requisições de login.
     *
     * @param dto      o objeto de transferência de dados de login contendo as credenciais do usuário
//     * @param request  a requisição HTTP
     * @param response a resposta HTTP
     * @return um ResponseEntity contendo o usuário autenticado
     */
    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO dto,
//                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        // Cria um token de autenticação usando as credenciais fornecidas
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(dto.usuario(), dto.senha());

        // Autentica o token
        authentication = authenticationProvider.authenticate(authentication);

        // Se a autenticação for bem-sucedida, salva o contexto de segurança
        if (authentication.isAuthenticated()) {

            Usuario usuario = (Usuario) authentication.getPrincipal();
            String jwt = jwtUtils.criarToken(usuario);
            Cookie cookieJwt = cookieUtils.criarCookie(jwt);
            response.addCookie(cookieJwt);
//            SecurityContext context = SecurityContextHolder.createEmptyContext();
//            context.setAuthentication(authentication);
//            securityContextRepository.saveContext(context, request, response);
        }

        // Retorna o usuário autenticado
        return ResponseEntity.ok((Usuario) authentication.getPrincipal());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user")
    public ResponseEntity<?> usuarioLogado() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = cookieUtils.removerCookie();
        response.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}