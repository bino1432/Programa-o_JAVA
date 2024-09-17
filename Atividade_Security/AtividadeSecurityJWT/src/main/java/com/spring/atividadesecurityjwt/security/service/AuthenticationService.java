package com.spring.atividadesecurityjwt.security.service;

import com.spring.atividadesecurityjwt.entity.Usuario;
import com.spring.atividadesecurityjwt.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = tentarBuscarUsuario(username);
        if (usuarioOptional.isEmpty()) {
            usuarioOptional = tentarBuscarEmail(username);
        }

        if(usuarioOptional.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuarioOptional.get();
    }

    private Optional<Usuario> tentarBuscarEmail(String username) {
        return usuarioRepository.findByEmail(username);
    }

    private Optional<Usuario> tentarBuscarUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
