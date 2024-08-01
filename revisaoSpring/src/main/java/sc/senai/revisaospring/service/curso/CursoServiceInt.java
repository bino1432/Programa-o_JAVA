package sc.senai.revisaospring.service.curso;

import sc.senai.revisaospring.model.Curso;
import sc.senai.revisaospring.model.dto.CursoDTO;

import java.util.List;

public interface CursoServiceInt {

    CursoDTO cadastrarCurso(CursoDTO dto);
    Curso buscarUmCurso(Long id);
    List<Curso> buscarTodosCursos();
    CursoDTO editarCurso(Long id, CursoDTO dto);
    void deletarCurso(Long id);
    void salvarCurso(Curso curso, CursoDTO dto);
}
