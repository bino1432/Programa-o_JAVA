package sc.senai.revisaospring.service.escola;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.revisaospring.model.Escola;
import sc.senai.revisaospring.model.dto.EscolaDTO;
import sc.senai.revisaospring.repository.EscolaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EscolaServiceImpl implements EscolaServiceInt{

    private EscolaRepository repository;

    @Override
    public EscolaDTO cadastrarEscola(EscolaDTO dto) {
        Escola escola = new Escola();
        salvarEscola(escola, dto);
        return dto;
    }

    @Override
    public Escola buscarUmaEscola(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Escola> buscarTodasEscolas() {
        return repository.findAll();
    }

    @Override
    public EscolaDTO editarEscola(Long id, EscolaDTO dto) {
        Escola escola = buscarUmaEscola(id);
        salvarEscola(escola, dto);
        return dto;
    }

    @Override
    public void deletarEscola(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void salvarEscola(Escola escola, EscolaDTO dto) {
        escola.setName(dto.nome());
        escola.setEndereco(dto.endereco());
        escola.setEmail(dto.email());
        escola.setListaDeCursos(dto.listaDeCursos());

        repository.save(escola);
    }
}
