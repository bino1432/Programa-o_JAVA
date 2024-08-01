package sc.senai.revisaospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sc.senai.revisaospring.model.Aluno;
import sc.senai.revisaospring.model.Professor;
import sc.senai.revisaospring.model.dto.AlunoDTO;
import sc.senai.revisaospring.model.dto.ProfessorDTO;
import sc.senai.revisaospring.service.professor.ProfessorServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorServiceImpl service;

    @PostMapping
    public ProfessorDTO cadastrarPorfessor(@RequestBody ProfessorDTO dto){
        return service.cadastrarProfessor(dto);
    }

    @GetMapping("/{id}")
    public Professor buscarUmProfessor(@PathVariable Long id){
        return service.buscarUmProfessor(id);
    }

    @GetMapping
    public List<Professor> buscarTodosProfessores(){
        return service.buscarTodosProfessores();
    }

    @PutMapping("/{id}")
    public ProfessorDTO editarProfessor(@PathVariable Long id, @RequestBody ProfessorDTO dto){
        return service.editarProfessor(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id){
        service.deletarProfessor(id);
    }
}
