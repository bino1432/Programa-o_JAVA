package sc.senai.revisaospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sc.senai.revisaospring.model.Endereco;
import sc.senai.revisaospring.model.dto.EnderecoDTO;
import sc.senai.revisaospring.service.endereco.EnderecoServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoServiceImpl service;

    @PostMapping
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO dto){
        return new ResponseEntity<>(
                service.cadastrarEndereco(dto), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Endereco buscarUmEndereco(@PathVariable Long id){
        return service.buscarUmEndereco(id);
    }

    @GetMapping
    public List<Endereco> buscarTodosEnderecos(){
        return service.buscarTodosEnderecos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> editarEndereco(@PathVariable Long id,
                                                      @RequestBody EnderecoDTO dto){
        return new ResponseEntity<>(
                service.editarEndereco(id, dto), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id){
        service.deleteEndereco(id);
    }
}
