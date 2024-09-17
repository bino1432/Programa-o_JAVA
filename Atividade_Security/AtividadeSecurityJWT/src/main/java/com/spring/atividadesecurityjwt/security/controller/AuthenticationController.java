package com.spring.atividadesecurityjwt.security.controller;

import com.spring.atividadesecurityjwt.entity.Usuario;
import com.spring.atividadesecurityjwt.security.controller.dto.LoginDTO;
import com.spring.atividadesecurityjwt.security.utils.CookieUtils;
import com.spring.atividadesecurityjwt.security.utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationProvider authenticationProvider;
    private JwtUtils jwtUtils;
    private CookieUtils cookieUtils;

    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO dto,
                                HttpServletResponse response) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(dto.username(), dto.senha());
        authentication = authenticationProvider.authenticate(authentication);

        if (authentication.isAuthenticated()) {
            Usuario usuario = (Usuario) authentication.getPrincipal();
            String jwt = jwtUtils.gerarToken(usuario);
            Cookie cookie = cookieUtils.criarCookie(jwt);
            response.addCookie(cookie);
        }
        return ResponseEntity.ok((Usuario) authentication.getPrincipal());
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = cookieUtils.removerCookie();
        response.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
