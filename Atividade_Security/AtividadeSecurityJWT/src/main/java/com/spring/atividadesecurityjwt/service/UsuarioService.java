package com.spring.atividadesecurityjwt.service;

import com.spring.atividadesecurityjwt.entity.Usuario;
import com.spring.atividadesecurityjwt.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;

    public void salvarUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios;
    }

    public String alterarSenha(Usuario usuario, String novaSenha) {
        Usuario usuarioSenha = repository.findById(usuario.getId()).get();
        usuarioSenha.setSenha(novaSenha);
        repository.save(usuarioSenha);
        return "Senha alterada com sucesso!";
    }

    public String editarUsuario(Long idUser, Usuario usuario) {
        Optional<Usuario> usuarioOptional = repository.findById(idUser);
        if(usuarioOptional.isEmpty()){
            throw new RuntimeException("Usuário não encontrado!");
        }
        Usuario usuarioEditado = usuarioOptional.get();
        usuarioEditado.setUsername(usuario.getUsername());
        usuarioEditado.setEmail(usuario.getEmail());
        usuarioEditado.setSenha(usuario.getSenha());
        usuarioEditado.setPerfil(usuario.getPerfil());
        repository.save(usuarioEditado);
        return "Usuário editado com sucesso!";
    }
}
