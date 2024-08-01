package sc.senai.revisaospring.service.turma;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.revisaospring.model.Turma;
import sc.senai.revisaospring.model.dto.TurmaDTO;
import sc.senai.revisaospring.repository.TurmaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaServiceImpl implements TurmaServiceInt{

    private TurmaRepository repository;

    @Override
    public TurmaDTO cadastrarTurma(TurmaDTO dto) {
        Turma turma = new Turma();
        salvarTurma(turma, dto);
        return dto;
    }

    @Override
    public Turma buscarUmaTurma(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Turma> buscarTodasTurmas() {
        return repository.findAll();
    }

    @Override
    public TurmaDTO editarTurma(Long id, TurmaDTO dto) {
        Turma turma = buscarUmaTurma(id);
        salvarTurma(turma, dto);
        return dto;
    }

    @Override
    public void deletarTurma(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void salvarTurma(Turma turma, TurmaDTO dto) {
        turma.setNome(dto.nome());
        turma.setEscola(dto.escola());
        turma.setListaDeAlunos(dto.listaDeAlunos());

        repository.save(turma);
    }
}
