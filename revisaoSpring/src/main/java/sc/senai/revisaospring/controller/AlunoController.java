package sc.senai.revisaospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sc.senai.revisaospring.model.Aluno;
import sc.senai.revisaospring.model.dto.AlunoDTO;
import sc.senai.revisaospring.service.aluno.AlunoServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoServiceImpl service;

    @PostMapping
    public AlunoDTO cadastrarAluno(@RequestBody AlunoDTO dto){
        return service.cadastrarAluno(dto);
    }

    @GetMapping("/{id}")
    public Aluno buscarUmAluno(@PathVariable Long id){
        return service.buscarUmAluno(id);
    }

    @GetMapping
    public List<Aluno> buscarTodosAlunos(){
        return service.buscarTodosAlunos();
    }

    @PutMapping("/{id}")
    public AlunoDTO editarAluno(@PathVariable Long id, @RequestBody AlunoDTO dto){
        return service.editarUmAluno(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id){
        service.deletarUmAluno(id);
    }
}
