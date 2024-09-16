package com.spring.security.security.config;

import com.spring.security.entity.Usuario;
import com.spring.security.security.utils.CookieUtils;
import com.spring.security.security.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
    private JwtUtils jwtUtil;

    @Autowired
    private CookieUtils cookieUtils;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String method = request.getMethod();


        if (!isPublicEndpoint(uri, method)) {
            try {
                Cookie[] cookies = request.getCookies();
                Optional<Cookie> cookieOptional = Arrays.stream(cookies).filter(cookie ->
                                cookie.getName().equals("USERTOKEN")).findAny().stream()
                        .findFirst();
                if (cookieOptional.isPresent()) {
                    Cookie cookie = cookieOptional.get();
                    String token = cookie.getValue();

                    Authentication authentication = jwtUtil.validarToken(token);
                    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                    securityContext.setAuthentication(authentication);
                    SecurityContextHolder.setContext(securityContext);

                    if(!uri.equals("/auth/logout")) {
                        String newToken = jwtUtil.criarToken((Usuario) authentication.getPrincipal());
                        cookie = cookieUtils.criarCookie(newToken);
                        response.addCookie(cookie);
                    }
                }
            } catch (Exception e) {
                response.setStatus(401);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private boolean isPublicEndpoint(String uri, String method) {
        return uri.equals("/auth/login") && method.equals("POST");
    }
}
