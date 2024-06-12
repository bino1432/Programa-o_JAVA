package br.senai.sc.demo.Service;

import br.senai.sc.demo.model.Usuario;
import br.senai.sc.demo.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
// serve para avisar que é uma service
@AllArgsConstructor
// Cria um construtor com todos os argumentos
// @NonNull
// Não permite que o atributo no construtor seja vazio
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario cadastroUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(Integer id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException();
        }
    }
}
