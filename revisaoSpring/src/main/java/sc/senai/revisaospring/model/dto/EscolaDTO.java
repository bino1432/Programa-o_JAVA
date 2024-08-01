package sc.senai.revisaospring.model.dto;

import sc.senai.revisaospring.model.Curso;
import sc.senai.revisaospring.model.Endereco;
import sc.senai.revisaospring.model.Professor;

import java.util.List;

public record EscolaDTO(

        String nome,
        Endereco endereco,
        String email,
        List<Curso> listaDeCursos

) {
}
