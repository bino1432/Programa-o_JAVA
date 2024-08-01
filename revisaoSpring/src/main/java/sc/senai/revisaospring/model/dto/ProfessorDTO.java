package sc.senai.revisaospring.model.dto;

import sc.senai.revisaospring.model.Endereco;
import sc.senai.revisaospring.model.Escola;

public record ProfessorDTO(

        String nome,
        String email,
        String telefone,
        Escola escola,
        Endereco endereco

) {
}
