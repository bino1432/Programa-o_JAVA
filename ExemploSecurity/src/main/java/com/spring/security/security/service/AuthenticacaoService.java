package com.spring.security.security.service;

import com.spring.security.entity.Usuario;
import com.spring.security.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe de serviço para lidar com a autenticação de usuários.
 */
@Service
@AllArgsConstructor
public class AuthenticacaoService implements UserDetailsService {

    private UsuarioRepository repository;

    /**
     * Carrega o usuário pelo nome de usuário.
     *
     * @param username o nome de usuário do usuário
     * @return os detalhes do usuário
     * @throws UsernameNotFoundException se o usuário não for encontrado
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = tentarBuscarUsuario(username);
        if(usuarioOptional.isEmpty()) {
            usuarioOptional = tentarBuscarEmail(username);
        }

        if(usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuarioOptional.get();
    }

    /**
     * Tenta encontrar o usuário pelo nome de usuário.
     *
     * @param username o nome de usuário do usuário
     * @return um Optional contendo o usuário, se encontrado, caso contrário, vazio
     */
    private Optional<Usuario> tentarBuscarUsuario(String username) {
        return repository.findByUsuario(username);
    }

    /**
     * Tenta encontrar o usuário pelo email.
     *
     * @param email o email do usuário
     * @return um Optional contendo o usuário, se encontrado, caso contrário, vazio
     */
    private Optional<Usuario> tentarBuscarEmail(String email) {
        return repository.findByEmail(email);
    }
}