package sc.senai.revisaospring.service.endereco;

import sc.senai.revisaospring.model.Endereco;
import sc.senai.revisaospring.model.dto.EnderecoDTO;

import java.util.List;

public interface EnderecoServiceInt {

    EnderecoDTO cadastrarEndereco(EnderecoDTO dto);
    Endereco buscarUmEndereco(Long id);
    List<Endereco> buscarTodosEnderecos();
    EnderecoDTO editarEndereco(Long id, EnderecoDTO dto);
    void deleteEndereco(Long id);
    void salvarEndereco(Endereco endereco, EnderecoDTO dto);
}
