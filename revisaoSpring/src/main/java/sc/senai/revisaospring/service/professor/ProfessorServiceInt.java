package sc.senai.revisaospring.service.professor;

import sc.senai.revisaospring.model.Escola;
import sc.senai.revisaospring.model.Professor;
import sc.senai.revisaospring.model.dto.EscolaDTO;
import sc.senai.revisaospring.model.dto.ProfessorDTO;

import java.util.List;

public interface ProfessorServiceInt {
    ProfessorDTO cadastrarProfessor(ProfessorDTO dto);
    Professor buscarUmProfessor(Long id);
    List<Professor> buscarTodosProfessores();
    ProfessorDTO editarProfessor(Long id, ProfessorDTO dto);
    void deletarProfessor(Long id);
    void salvarProfessor(Professor professor, ProfessorDTO dto);
}
