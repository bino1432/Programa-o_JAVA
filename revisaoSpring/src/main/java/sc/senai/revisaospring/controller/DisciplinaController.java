package sc.senai.revisaospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sc.senai.revisaospring.model.Disciplina;
import sc.senai.revisaospring.model.dto.DisciplinaPostDTO;
import sc.senai.revisaospring.model.dto.DisciplinaPutDTO;
import sc.senai.revisaospring.service.disciplina.DisciplinaServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/disciplina")
public class DisciplinaController {

    private DisciplinaServiceImpl service;

    @PostMapping
    public DisciplinaPostDTO cadastraDisciplinas(@RequestBody DisciplinaPostDTO dto){
        return service.cadastrarDisciplina(dto);
    }

    @GetMapping("/{id}")
    public Disciplina buscarDisciplina(@PathVariable Long id){
        return service.buscarUmaDisciplina(id);
    }

    @GetMapping
    public List<Disciplina> buscarTodasDisciplinas(){
        return service.buscarTodasDisciplinas();
    }

    @PutMapping("/{id}")
    public DisciplinaPutDTO editarDisciplina(@PathVariable Long id, @RequestBody DisciplinaPutDTO dto){
        return service.editarDisciplina(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable Long id){
        service.deletarDisciplinas(id);
    }
}
