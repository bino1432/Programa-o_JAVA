package sc.senai.revisaospring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sc.senai.revisaospring.model.Curso;
import sc.senai.revisaospring.model.dto.CursoDTO;
import sc.senai.revisaospring.service.curso.CursoServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    private CursoServiceImpl service;

    @PostMapping
    public CursoDTO cadastrarCurso(@RequestBody CursoDTO dto){
        return service.cadastrarCurso(dto);
    }

    @GetMapping("/{id}")
    public Curso buscarCurso(@PathVariable Long id){
        return service.buscarUmCurso(id);
    }

    @GetMapping
    public List<Curso> buscarTodosCurso(){
        return service.buscarTodosCursos();
    }

    @PutMapping("/{id}")
    public CursoDTO editarCurso(@PathVariable Long id,@RequestBody CursoDTO dto){
        return service.editarCurso(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable Long id){
        service.deletarCurso(id);
    }
}
