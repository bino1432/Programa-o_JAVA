package com.spring.security.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.spring.security.entity.Usuario;
import com.spring.security.security.service.AuthenticacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
public class JwtUtils {

    @Autowired
    private AuthenticacaoService autenticacaoService;

    @Value("${security.secret:aV##_,Jqu>I!9]E81;\\\\%}")
    private String senha;

    public String criarToken(Usuario usuario) {
        Instant instantDaAssinatura = Instant.now();
        Instant instanteDeExpiracao = instantDaAssinatura.plus(1, ChronoUnit.HOURS);
        Algorithm algorithm = Algorithm.HMAC256(senha);
        String jwt = JWT.create()
                .withIssuer("Top Care")
                .withIssuedAt(instantDaAssinatura)
                .withSubject(usuario.getUsuario())
                .withExpiresAt(instanteDeExpiracao)
                .withArrayClaim("authorities", usuario.getAuthorities().stream()
                        .map(a -> a.getAuthority()).toArray(String[]::new))
                .sign(algorithm);

        return jwt;
    }

    public Authentication validarToken(String token) {
        String username = JWT.require(
                Algorithm.HMAC256(senha)).
                build().
                verify(token).
                getSubject();
        Usuario usuario = (Usuario) autenticacaoService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(
                usuario,
                usuario.getPassword(),
                usuario.getAuthorities());
    }
}
