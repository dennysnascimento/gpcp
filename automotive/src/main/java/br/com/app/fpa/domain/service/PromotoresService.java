package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.exceptions.PromotoresException;
import br.com.app.fpa.domain.model.Promotores;
import br.com.app.fpa.domain.repository.PromotoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class PromotoresService {

    private final PromotoresRepository promotoresRepository;

    @Autowired
    public PromotoresService(PromotoresRepository promotoresRepository) {
        this.promotoresRepository = promotoresRepository;
    }

    public Promotores findById(Long id) throws PromotoresException {
        Optional<Promotores> promotorOptional = promotoresRepository.findById(id);
        return promotorOptional.orElseThrow(() -> new PromotoresException(ID_NOT_FOUND));
    }

    public Page<Promotores> findAll(Pageable pageable) {
        List<Promotores> promotoresList = promotoresRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), promotoresList.size());
        return new PageImpl<>(promotoresList.subList(start, end), pageable, promotoresList.size());
    }

    public void deleteById(Long id) {
        promotoresRepository.deleteById(id);
    }

    public Promotores update(Promotores promotor) {
        // Verificar se o promotor existe no banco de dados
        if (!promotoresRepository.existsById(promotor.getId())) {
            throw new IllegalArgumentException("Promotor não encontrado");
        }
        return promotoresRepository.save(promotor);
    }

    public Promotores save(Promotores promotor) {
        return promotoresRepository.save(promotor);
    }

    public boolean existsById(Long id) {
        return promotoresRepository.existsById(id);
    }
}
