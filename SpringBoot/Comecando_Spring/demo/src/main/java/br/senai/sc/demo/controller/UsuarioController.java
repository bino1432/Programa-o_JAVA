package br.senai.sc.demo.controller;

import br.senai.sc.demo.Service.UsuarioService;
import br.senai.sc.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// RestController - Determina que a classe seja gerenciada pelo Spring
// Facilita a identificação dos endpoints pelo Spring

// EndPoints são interfaces que posibilitam que outras aplicações interajam com a nossa
// EndPoints possuem uma rota e um tipo de metodo

// RequestBody - indica que os dados da requisição estão no corpo da mensagem
// PathVariable - indica que o valor da informação vira na rota (path)

// as {} no path são usadas parar ler variaveis

// Não precisa ser o mesmo nome da variavel do endPoint e da função
// @PatchMapping(/{idpatch})
// public String endpoitPatch(@PathVariable(name = "idpatch") int id)

// @Autowired
// depois de criar um usuarioController ele cria um usuarioService

@RequestMapping("/usuario")
// Determina qual o endpoint base para todos os outros metodos

public final class UsuarioController {

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private UsuarioService usuarioService;

    // Get de um usuario especifico
    @GetMapping("/{id}")
    // GET - retorna um valor que for solicitado, podendo ser um objeto ou elemento especifico
    public Usuario buscarUsuario(@PathVariable Integer id) throws Exception{
        return usuarioService.buscarUsuario(id);
    }

    // Get para todos os usuarios
    @GetMapping
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioService.buscarTodosUsuarios();
    }

    @PostMapping
    // POST - Receber informações para salvalos em algum lugar
    public String cadastroUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return "POST - Olá " + usuario.getNome() + " Seja bem Vindo! \n" + usuario;
    }

    // Put para fazer o update de um usuário
    @PutMapping
    // PUT - Utilizado para fazer uma atualização completa das informações
    public String atualizarUsuario(@RequestBody Usuario usuario){
        usuarioService.updateUsuario(usuario);
        return "PUT - Usuário " + usuario.getNome() + " atualizado com sucesso!!! \n" + usuario;
    }

    // PATCH para atualizar a senha do usuario
    @PatchMapping("/{id}")
    // PATCH - Atualizão parcial dos dados (normalmente 1 atributo)
    public String atualizarSenha(@PathVariable Integer id, @RequestBody String novaSenha) throws Exception{
        usuarioService.alterarSenha(id, novaSenha);
        return "PATCH - Senha alterada com Sucesso!!!";
    }

    // Delete de um usuario
    @DeleteMapping("/{id}")
    // DELETE - Deletar ou desabilitar algo
    public String deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
        return "DELETE - Usuario com o id: " + id + " Deletado!!!";
    }
}
