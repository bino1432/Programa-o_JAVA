package sc.senai.revisaospring.service.disciplina;

import sc.senai.revisaospring.model.Disciplina;
import sc.senai.revisaospring.model.dto.DisciplinaPostDTO;
import sc.senai.revisaospring.model.dto.DisciplinaPutDTO;

import java.util.List;

public interface DisciplinaServiceInt {

    DisciplinaPostDTO cadastrarDisciplina(DisciplinaPostDTO dto);
    Disciplina buscarUmaDisciplina(Long id);
    List<Disciplina> buscarTodasDisciplinas();
    DisciplinaPutDTO editarDisciplina(Long id, DisciplinaPutDTO dto);
    void deletarDisciplinas(Long id);
    void salvarDisciplinas(Disciplina disciplina, DisciplinaPostDTO dto);
    void adicionarProfessor(Disciplina disciplina, DisciplinaPutDTO dto);
}
