package br.senai.sc.demo.controller;

import br.senai.sc.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

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

@RequestMapping("/usuario")
// Determina qual o endpoint base para todos os outros metodos

public class UsuarioController {

//    @GetMapping
//    // GET - retorna um valor que for solicitado, podendo ser um objeto ou elemento especifico
//    public String endpointGet(){
//        return "GET - Olá!";
//    }

    @PostMapping
    // POST - Receber informações para salvalos em algum lugar
    public String cadastroUsuario(@RequestBody Usuario usuario){
        return "POST - Olá " + usuario.getNome() + " Seja bem Vindo! \n" + usuario;
    }

//    @PutMapping("/{id}")
//    // PUT - Utilizado para fazer uma atualização completa das informações
//    public String endpointPut(@PathVariable int id, @RequestBody String nome){
//        return "PUT - Olá " + nome + " Seja bem Vindo! de ID = " + id;
//    }

//    @PatchMapping("/{id}")
//    // PATCH - Atualizão parcial dos dados (normalmente 1 atributo)
//    public String endpointPatch(@PathVariable int id, @RequestBody String nome){
//        return "PATCH - Olá " + nome + " Seja bem Vindo! de ID = " + id;
//    }

//    @DeleteMapping("/{id}")
//    // DELETE - Deletar ou desabilitar algo
//    public String endpointDelete(@PathVariable int id){
//        return "DELETE - ID = " + id + " Deletado.";
//    }
}
