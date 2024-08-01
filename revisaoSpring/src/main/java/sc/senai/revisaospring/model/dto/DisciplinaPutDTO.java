package sc.senai.revisaospring.model.dto;

import sc.senai.revisaospring.model.Professor;

import java.util.List;

public record DisciplinaPutDTO(

        String nome,
        List<Professor> listaDeProfessores

) {
}
