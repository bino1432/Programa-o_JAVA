package sc.senai.revisaospring.model.dto;

import sc.senai.revisaospring.model.Aluno;
import sc.senai.revisaospring.model.Escola;

import java.util.List;

public record TurmaDTO(

        String nome,
        Escola escola,
        List<Aluno> listaDeAlunos

) {
}
