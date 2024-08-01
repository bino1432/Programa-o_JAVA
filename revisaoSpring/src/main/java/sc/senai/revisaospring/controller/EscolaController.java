package sc.senai.revisaospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sc.senai.revisaospring.model.Aluno;
import sc.senai.revisaospring.model.Escola;
import sc.senai.revisaospring.model.dto.AlunoDTO;
import sc.senai.revisaospring.model.dto.EscolaDTO;
import sc.senai.revisaospring.service.escola.EscolaServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/escola")
public class EscolaController {

    private EscolaServiceImpl service;

    @PostMapping
    public EscolaDTO cadastrarEscola(@RequestBody EscolaDTO dto){
        return service.cadastrarEscola(dto);
    }

    @GetMapping("/{id}")
    public Escola buscarUmaEscola(@PathVariable Long id){
        return service.buscarUmaEscola(id);
    }

    @GetMapping
    public List<Escola> buscarTodasEscolas(){
        return service.buscarTodasEscolas();
    }

    @PutMapping("/{id}")
    public EscolaDTO editarEscola(@PathVariable Long id, @RequestBody EscolaDTO dto){
        return service.editarEscola(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEscola(@PathVariable Long id){
        service.deletarEscola(id);
    }
}
