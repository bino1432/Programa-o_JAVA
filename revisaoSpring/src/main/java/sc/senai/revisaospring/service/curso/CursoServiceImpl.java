package sc.senai.revisaospring.service.curso;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.revisaospring.model.Curso;
import sc.senai.revisaospring.model.dto.CursoDTO;
import sc.senai.revisaospring.repository.CursoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoServiceInt{

    private CursoRepository repository;

    @Override
    public CursoDTO cadastrarCurso(CursoDTO dto) {
        Curso curso = new Curso();
        salvarCurso(curso, dto);
        return dto;
    }

    @Override
    public Curso buscarUmCurso(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Curso> buscarTodosCursos() {
        return repository.findAll();
    }

    @Override
    public CursoDTO editarCurso(Long id, CursoDTO dto) {
        Curso curso = buscarUmCurso(id);
        salvarCurso(curso, dto);
        return dto;
    }

    @Override
    public void deletarCurso(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void salvarCurso(Curso curso, CursoDTO dto) {
        curso.setNome(dto.nome());
        curso.setListaDeDisciplinas(dto.listaDeDisciplinas());

        repository.save(curso);
    }
}
