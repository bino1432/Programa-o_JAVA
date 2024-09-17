package com.spring.atividadesecurityjwt.security.config;

import com.spring.atividadesecurityjwt.entity.Usuario;
import com.spring.atividadesecurityjwt.security.utils.CookieUtils;
import com.spring.atividadesecurityjwt.security.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private CookieUtils cookieUtils;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        if (!isPublicEndpoint(uri, method)) {
            try {
                Cookie[] cookies = request.getCookies();
                Optional<Cookie> cookieOptional = Arrays.stream(cookies).filter(cookie ->
                        cookie.getName().equals("USERTOKEN")).findAny().stream().findFirst();
                if (cookieOptional.isPresent()) {
                    Cookie cookie = cookieOptional.get();
                    String token = cookie.getValue();

                    Authentication authentication = jwtUtils.validarToken(token);
                    SecurityContext context = SecurityContextHolder.createEmptyContext();
                    context.setAuthentication(authentication);
                    SecurityContextHolder.setContext(context);

                    if (!uri.equals("/api/auth/logout")) {
                        String newToken = jwtUtils.gerarToken((Usuario) authentication.getPrincipal());
                        cookie = cookieUtils.criarCookie(newToken);
                        response.addCookie(cookie);
                    }

                }
            } catch (Exception e) {
                response.setStatus(401);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean isPublicEndpoint (String uri, String method){
        return uri.equals("/api/auth/login") || uri.equals("api/usuarios")
                && method.equals("POST") || method.equals("GET");
    }
}
