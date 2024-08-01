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
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Endereco endereco;

    private String email;

    @OneToMany(mappedBy = "escola")
    private List<Professor> listaDeProfessores;

    @OneToMany
    @JoinColumn(name = "escola_id")
    private List<Curso> listaDeCursos;
}
