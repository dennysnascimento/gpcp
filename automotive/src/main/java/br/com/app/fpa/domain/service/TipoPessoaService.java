package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.exceptions.TipoPessoaException;
import br.com.app.fpa.domain.model.TipoPessoa;
import br.com.app.fpa.domain.repository.TipoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class TipoPessoaService {

    private final TipoPessoaRepository tipoPessoaRepository;

    @Autowired
    public TipoPessoaService(TipoPessoaRepository tipoPessoaRepository) {
        this.tipoPessoaRepository = tipoPessoaRepository;
    }

    public TipoPessoa findById(Long id) throws TipoPessoaException {
        Optional<TipoPessoa> tipoPessoaOptional = tipoPessoaRepository.findById(id);
        return tipoPessoaOptional.orElseThrow(() -> new TipoPessoaException(ID_NOT_FOUND));
    }

    public Page<TipoPessoa> findAll(Pageable pageable) {
        List<TipoPessoa> tipoPessoaList = tipoPessoaRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), tipoPessoaList.size());
        return new PageImpl<>(tipoPessoaList.subList(start, end), pageable, tipoPessoaList.size());
    }

    public void deleteById(Long id) {
        tipoPessoaRepository.deleteById(id);
    }

    public TipoPessoa update(TipoPessoa tipoPessoa) {
        // Verificar se o tipo de pessoa existe no banco de dados
        if (!tipoPessoaRepository.existsById(tipoPessoa.getId())) {
            throw new IllegalArgumentException("Tipo de Pessoa não encontrado");
        }
        return tipoPessoaRepository.save(tipoPessoa);
    }

    public TipoPessoa save(TipoPessoa tipoPessoa) {
        return tipoPessoaRepository.save(tipoPessoa);
    }

    public boolean existsById(Long id) {
        return tipoPessoaRepository.existsById(id);
    }
}
