package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.exceptions.PilotosException;
import br.com.app.fpa.domain.model.Pilotos;
import br.com.app.fpa.domain.repository.PilotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class PilotosService {

    private final PilotosRepository pilotosRepository;

    @Autowired
    public PilotosService(PilotosRepository pilotosRepository) {
        this.pilotosRepository = pilotosRepository;
    }

    public Pilotos findById(Long id) throws PilotosException {
        Optional<Pilotos> pilotoOptional = pilotosRepository.findById(id);
        return pilotoOptional.orElseThrow(() -> new PilotosException(ID_NOT_FOUND));
    }

    public Page<Pilotos> findAll(Pageable pageable) {
        List<Pilotos> pilotosList = pilotosRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), pilotosList.size());
        return new PageImpl<>(pilotosList.subList(start, end), pageable, pilotosList.size());
    }

    public void deleteById(Long id) {
        pilotosRepository.deleteById(id);
    }

    public Pilotos update(Pilotos piloto) {
        // Verificar se o piloto existe no banco de dados
        if (!pilotosRepository.existsById(piloto.getId())) {
            throw new IllegalArgumentException("Piloto não encontrado");
        }
        return pilotosRepository.save(piloto);
    }

    public Pilotos save(Pilotos piloto) {
        return pilotosRepository.save(piloto);
    }

    public boolean existsById(Long id) {
        return pilotosRepository.existsById(id);
    }
}
