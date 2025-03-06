package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.model.Endereco;
import br.com.app.fpa.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco findByCep(String cep) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(cep);
        return enderecoOptional.orElse(null);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public void deleteByCep(String cep) {
        enderecoRepository.deleteById(cep);
    }

    public Endereco update(Endereco endereco) {
        // Verificar se o endereco existe no banco de dados
        if (!enderecoRepository.existsById(endereco.getCep())) {
            throw new IllegalArgumentException("Endereço não encontrado");
        }
        return enderecoRepository.save(endereco);
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public boolean existsByCep(String cep) {
        return enderecoRepository.existsById(cep);
    }
}