package sc.senai.revisaospring.model.dto;

import sc.senai.revisaospring.model.Disciplina;

import java.util.List;

public record CursoDTO (

        String nome,
        List<Disciplina> listaDeDisciplinas

){
}
