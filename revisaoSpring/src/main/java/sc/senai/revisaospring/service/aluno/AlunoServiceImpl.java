package sc.senai.revisaospring.service.aluno;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.revisaospring.model.Aluno;
import sc.senai.revisaospring.model.dto.AlunoDTO;
import sc.senai.revisaospring.repository.AlunoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AlunoServiceImpl implements AlunoServiceInt{

    private AlunoRepository repository;

    @Override
    public AlunoDTO cadastrarAluno(AlunoDTO dto) {
        Aluno aluno =  new Aluno();
        salvarAluno(aluno, dto);
        return dto;
    }

    @Override
    public List<Aluno> buscarTodosAlunos() {
        return repository.findAll();
    }

    @Override
    public Aluno buscarUmAluno(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public AlunoDTO editarUmAluno(Long id, AlunoDTO dto) {
        Aluno aluno = buscarUmAluno(id);
        salvarAluno(aluno, dto);
        return dto;
    }

    @Override
    public void deletarUmAluno(Long id) {
        repository.deleteById(id);
    }

    public void salvarAluno(Aluno aluno, AlunoDTO dto) {
        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setTelefone(dto.telefone());
        aluno.setEndereco(dto.endereco());

        repository.save(aluno);
    }
}
