package sc.senai.revisaospring.service.escola;

import sc.senai.revisaospring.model.Curso;
import sc.senai.revisaospring.model.Escola;
import sc.senai.revisaospring.model.dto.CursoDTO;
import sc.senai.revisaospring.model.dto.EscolaDTO;

import java.util.List;

public interface EscolaServiceInt {

    EscolaDTO cadastrarEscola(EscolaDTO dto);
    Escola buscarUmaEscola(Long id);
    List<Escola> buscarTodasEscolas();
    EscolaDTO editarEscola(Long id, EscolaDTO dto);
    void deletarEscola(Long id);
    void salvarEscola(Escola escola, EscolaDTO dto);
}
