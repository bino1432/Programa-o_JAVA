package sc.senai.revisaospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sc.senai.revisaospring.model.Turma;
import sc.senai.revisaospring.model.dto.TurmaDTO;
import sc.senai.revisaospring.service.turma.TurmaServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/turma")
public class TurmaController {

    private TurmaServiceImpl service;

    @PostMapping
    public TurmaDTO cadastrarTurma(@RequestBody TurmaDTO dto){
        return service.cadastrarTurma(dto);
    }

    @GetMapping("/{id}")
    public Turma buscarTurma(@PathVariable Long id){
        return service.buscarUmaTurma(id);
    }

    @GetMapping
    public List<Turma> buscarTodasTurmas(){
        return service.buscarTodasTurmas();
    }

    @PutMapping("/{id}")
    public TurmaDTO editarTurma(@PathVariable Long id, @RequestBody TurmaDTO dto){
        return service.editarTurma(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarTurma(@PathVariable Long id){
        service.deletarTurma(id);
    }
}
