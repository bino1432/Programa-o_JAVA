package sc.senai.revisaospring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @ManyToOne
    private Escola escola;

    @ManyToMany(mappedBy = "listaDeProfessores")
    private List<Disciplina> listaDeDisciplinas;

    @OneToOne
    private Endereco endereco;
}
