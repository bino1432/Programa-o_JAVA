package sc.senai.revisaospring.service.endereco;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.revisaospring.model.Endereco;
import sc.senai.revisaospring.model.dto.EnderecoDTO;
import sc.senai.revisaospring.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoServiceImpl implements EnderecoServiceInt{

    private EnderecoRepository repository;

    @Override
    public EnderecoDTO cadastrarEndereco(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        salvarEndereco(endereco, dto);
        return dto;
    }

    @Override
    public Endereco buscarUmEndereco(Long id) {
        Optional<Endereco> endereco = repository.findById(id);
        return endereco.get();
    }

    @Override
    public List<Endereco> buscarTodosEnderecos() {
        return repository.findAll();
    }

    @Override
    public EnderecoDTO editarEndereco(Long id, EnderecoDTO dto) {
        Endereco endereco = buscarUmEndereco(id);
        salvarEndereco(endereco, dto);
        return dto;
    }

    @Override
    public void deleteEndereco(Long id) {
        repository.deleteById(id); ;
    }

    public void salvarEndereco(Endereco endereco, EnderecoDTO dto){
        endereco.setRua(dto.rua());
        endereco.setNumero(dto.numero());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setBairro(dto.bairro());
        endereco.setCep(dto.cep());

        repository.save(endereco);
    }
}
