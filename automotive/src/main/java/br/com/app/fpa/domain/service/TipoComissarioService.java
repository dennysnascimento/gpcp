package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.exceptions.TipoComissarioException;
import br.com.app.fpa.domain.model.TipoComissario;
import br.com.app.fpa.domain.repository.TipoComissarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class TipoComissarioService {

    private final TipoComissarioRepository tipoComissarioRepository;

    @Autowired
    public TipoComissarioService(TipoComissarioRepository tipoComissarioRepository) {
        this.tipoComissarioRepository = tipoComissarioRepository;
    }

    public TipoComissario findById(Long id) throws TipoComissarioException {
        Optional<TipoComissario> tipoComissarioOptional = tipoComissarioRepository.findById(id);
        return tipoComissarioOptional.orElseThrow(() -> new TipoComissarioException(ID_NOT_FOUND));
    }


    public Page<TipoComissario> findAll(Pageable pageable) {
        List<TipoComissario> tipoComissarioList = tipoComissarioRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), tipoComissarioList.size());
        return new PageImpl<>(tipoComissarioList.subList(start, end), pageable, tipoComissarioList.size());
    }

    public void deleteById(Long id) {
        tipoComissarioRepository.deleteById(id);
    }

    public TipoComissario update(TipoComissario tipoComissario) {
        // Verificar se o tipo de comissário existe no banco de dados
        if (!tipoComissarioRepository.existsById(tipoComissario.getId())) {
            throw new IllegalArgumentException("Tipo de Comissário não encontrado");
        }
        return tipoComissarioRepository.save(tipoComissario);
    }

    public TipoComissario save(TipoComissario tipoComissario) {
        return tipoComissarioRepository.save(tipoComissario);
    }

    public boolean existsById(Long id) {
        return tipoComissarioRepository.existsById(id);
    }
}
