package sc.senai.revisaospring.service.aluno;

import sc.senai.revisaospring.model.Aluno;
import sc.senai.revisaospring.model.dto.AlunoDTO;

import java.util.List;

public interface AlunoServiceInt {

    AlunoDTO cadastrarAluno(AlunoDTO dto);
    List<Aluno> buscarTodosAlunos();
    Aluno buscarUmAluno(Long id);
    AlunoDTO editarUmAluno(Long id, AlunoDTO dto);
    void deletarUmAluno(Long id);
    void salvarAluno(Aluno aluno, AlunoDTO dto);
}
