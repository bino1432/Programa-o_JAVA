package sc.senai.revisaospring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.revisaospring.model.dto.EnderecoDTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private Integer numero;

    private String cidade;

    private String estado;

    private String bairro;

    private Long cep;

    public EnderecoDTO toDto(){
        return new EnderecoDTO(
                this.rua,
                this.numero,
                this.cidade,
                this.estado,
                this.bairro,
                this.cep
        );
    }
}
