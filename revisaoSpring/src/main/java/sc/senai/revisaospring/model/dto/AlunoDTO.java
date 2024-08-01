package sc.senai.revisaospring.model.dto;

import sc.senai.revisaospring.model.Endereco;

public record AlunoDTO(

        String nome,
        String email,
        String telefone,
        Endereco endereco

) {
}
