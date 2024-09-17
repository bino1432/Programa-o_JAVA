package com.spring.atividadesecurityjwt.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.spring.atividadesecurityjwt.entity.Usuario;
import com.spring.atividadesecurityjwt.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JwtUtils {

    @Autowired
    private AuthenticationService authenticationService;

    @Value("${security.secret:aV##_,Jqu>I!9]E81;\\\\%}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        Instant instanteDaAssinatura = Instant.now();
        Instant instanteDeExpiracao = instanteDaAssinatura.plus(1, ChronoUnit.HOURS);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String jwt = JWT.create()
                .withIssuer("AOBA")
                .withIssuedAt(instanteDaAssinatura)
                .withSubject(usuario.getUsername())
                .withExpiresAt(instanteDeExpiracao)
                .withArrayClaim("authorities", usuario.getAuthorities().stream()
                        .map(a -> a.getAuthority()).toArray(String[]::new))
                .sign(algorithm);
        return jwt;
    }

    public Authentication validarToken(String token) {
        String username = JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getSubject();
        Usuario usuario = (Usuario) authenticationService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(
                usuario,
                usuario.getPassword(),
                usuario.getAuthorities());
    }
}
