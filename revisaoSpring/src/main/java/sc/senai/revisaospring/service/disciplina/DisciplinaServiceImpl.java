package sc.senai.revisaospring.service.disciplina;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.revisaospring.model.Disciplina;
import sc.senai.revisaospring.model.dto.DisciplinaPostDTO;
import sc.senai.revisaospring.model.dto.DisciplinaPutDTO;
import sc.senai.revisaospring.repository.DisciplinaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaServiceInt{

    private DisciplinaRepository repository;

    @Override
    public DisciplinaPostDTO cadastrarDisciplina(DisciplinaPostDTO dto) {
        Disciplina disciplina = new Disciplina();
        salvarDisciplinas(disciplina, dto);
        return dto;
    }

    @Override
    public Disciplina buscarUmaDisciplina(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Disciplina> buscarTodasDisciplinas() {
        return repository.findAll();
    }

    @Override
    public DisciplinaPutDTO editarDisciplina(Long id, DisciplinaPutDTO dto) {
        Disciplina disciplina = buscarUmaDisciplina(id);
        adicionarProfessor(disciplina, dto);
        return dto;
    }

    @Override
    public void deletarDisciplinas(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void salvarDisciplinas(Disciplina disciplina, DisciplinaPostDTO dto) {
        disciplina.setNome(dto.nome());

        repository.save(disciplina);
    }

    @Override
    public void adicionarProfessor(Disciplina disciplina, DisciplinaPutDTO dto) {
        disciplina.setListaDeProfessores(dto.listaDeProfessores());

        repository.save(disciplina);
    }
}
