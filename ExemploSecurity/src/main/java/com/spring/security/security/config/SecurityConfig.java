package com.spring.security.security.config;

import com.spring.security.enums.Perfil;
import com.spring.security.security.service.AuthenticacaoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Classe de configuração para o Spring Security.
 */
@AllArgsConstructor
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    private JwtFilter jwtFilter;

    /**
     * Bean para SecurityContextRepository.
     *
     * @return uma instância de SecurityContextRepository
     */
    @Bean
    public SecurityContextRepository securityContextRepository(){
        return new HttpSessionSecurityContextRepository();
    }

    /**
     * Bean para AuthenticationProvider.
     *
     * @param builder o AuthenticationManagerBuilder
     * @param service o AuthenticacaoService
     * @return uma instância de AuthenticationProvider
     * @throws Exception se ocorrer um erro durante a configuração
     */
    @Bean
    public AuthenticationProvider authenticationManager(
            AuthenticationManagerBuilder builder,
            AuthenticacaoService service) throws Exception {
        DaoAuthenticationProvider authenticationProvider =
                new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(service);
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return authenticationProvider;
    }

    /**
     * Bean para SecurityFilterChain.
     *
     * @param config a configuração do HttpSecurity
     * @return uma instância de SecurityFilterChain
     * @throws Exception se ocorrer um erro durante a configuração
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity config) throws Exception {
//        config.securityContext(custom ->
//                securityContextRepository());
        config.formLogin(custom -> custom.disable());
        config.logout(custom -> custom.disable());
        config.csrf(custom -> custom.disable());
        config.sessionManagement(custom ->
                /**/custom.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        config.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        config.cors(custom -> custom.configurationSource(corsConfigurationSource()));
//        config.authorizeHttpRequests(http -> {
//            http.requestMatchers(
//                            HttpMethod.POST, "/usuario")
//                    .hasAuthority(Perfil.ADMIN.getAuthority());
//            http.requestMatchers(
//                            HttpMethod.POST, "/auth/login")
//                    .permitAll();
//            http.anyRequest().authenticated();
//        });
        return config.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}