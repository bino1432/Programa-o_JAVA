package br.senai.sc.demo.Service;

import br.senai.sc.demo.model.Usuario;
import br.senai.sc.demo.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Usuario buscarUsuario(Integer id) throws Exception{
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    private void validarUsuario(Integer id){
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public void deletarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            if(usuarioRepository.existsById(id)){
                throw new RuntimeException("Não foi possível deletar o usuário de id: " + id);
            }
            return;
        }
        throw new RuntimeException("Usuário não encontrado");

    }

    public void updateUsuario(Usuario usuario) {
        validarUsuario(usuario.getId());
        usuarioRepository.save(usuario);
    }

    public void alterarSenha(Integer id, String novaSenha) throws Exception{
        Usuario usuario = buscarUsuario(id);
        usuario.setSenha(novaSenha);
        usuarioRepository.save(usuario);
    }
}
