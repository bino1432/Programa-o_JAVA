package com.spring.atividadesecurityjwt.security.utils;

import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtils {

    public Cookie criarCookie(String jwt) {
        Cookie cookie = new Cookie("USERTOKEN", jwt);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        return cookie;
    }

    public Cookie removerCookie() {
        Cookie cookie = new Cookie("USERTOKEN", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setDomain("localhost");
        return cookie;
    }
}
