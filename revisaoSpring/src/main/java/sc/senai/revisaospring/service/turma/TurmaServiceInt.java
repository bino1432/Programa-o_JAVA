package sc.senai.revisaospring.service.turma;

import sc.senai.revisaospring.model.Turma;
import sc.senai.revisaospring.model.dto.TurmaDTO;

import java.util.List;

public interface TurmaServiceInt {

    TurmaDTO cadastrarTurma(TurmaDTO dto);
    Turma buscarUmaTurma(Long id);
    List<Turma> buscarTodasTurmas();
    TurmaDTO editarTurma(Long id, TurmaDTO dto);
    void deletarTurma(Long id);
    void salvarTurma(Turma turma, TurmaDTO dto);

}
