package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.exceptions.ModalidaeException;
import br.com.app.fpa.domain.model.Modalidades;
import br.com.app.fpa.domain.repository.ModalidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class ModalidadesService {

    private final ModalidadesRepository modalidadesRepository;

    @Autowired
    public ModalidadesService(ModalidadesRepository modalidadesRepository) {
        this.modalidadesRepository = modalidadesRepository;
    }

    public Modalidades findById(Long id) throws ModalidaeException {
        Optional<Modalidades> modalidadeOptional = modalidadesRepository.findById(id);
        return modalidadeOptional.orElseThrow(() -> new ModalidaeException(ID_NOT_FOUND));
    }

    public Page<Modalidades> findAll(Pageable pageable) {
        List<Modalidades> modalidadesList = modalidadesRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), modalidadesList.size());
        return new PageImpl<>(modalidadesList.subList(start, end), pageable, modalidadesList.size());
    }

    public void deleteById(Long id) {
        modalidadesRepository.deleteById(id);
    }

    public Modalidades update(Modalidades modalidade) {
        // Verificar se a modalidade existe no banco de dados
        if (!modalidadesRepository.existsById(modalidade.getId())) {
            throw new IllegalArgumentException("Modalidade não encontrada");
        }
        return modalidadesRepository.save(modalidade);
    }

    public Modalidades save(Modalidades modalidade) {
        return modalidadesRepository.save(modalidade);
    }

    public boolean existsById(Long id) {
        return modalidadesRepository.existsById(id);
    }
}
