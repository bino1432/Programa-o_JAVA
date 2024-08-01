package sc.senai.revisaospring.service.professor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.revisaospring.model.Professor;
import sc.senai.revisaospring.model.dto.ProfessorDTO;
import sc.senai.revisaospring.repository.ProfessorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorServiceInt{

    private ProfessorRepository repository;

    @Override
    public ProfessorDTO cadastrarProfessor(ProfessorDTO dto) {
        Professor professor = new Professor();
        salvarProfessor(professor, dto);
        return dto;
    }

    @Override
    public Professor buscarUmProfessor(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Professor> buscarTodosProfessores() {
        return repository.findAll();
    }

    @Override
    public ProfessorDTO editarProfessor(Long id, ProfessorDTO dto) {
        Professor professor = buscarUmProfessor(id);
        salvarProfessor(professor, dto);
        return dto;
    }

    @Override
    public void deletarProfessor(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void salvarProfessor(Professor professor, ProfessorDTO dto) {
        professor.setEmail(dto.email());
        professor.setNome(dto.nome());
        professor.setTelefone(dto.telefone());
        professor.setEndereco(dto.endereco());
        professor.setEscola(dto.escola());

        repository.save(professor);
    }
}
