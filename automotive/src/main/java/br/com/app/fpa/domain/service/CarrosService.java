package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.enums.MensagensErroEnum;
import br.com.app.fpa.domain.exceptions.CarrosException;
import br.com.app.fpa.domain.model.Carros;
import br.com.app.fpa.domain.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class CarrosService {

    private final CarrosRepository carrosRepository;

    @Autowired
    public CarrosService(CarrosRepository carrosRepository) {
        this.carrosRepository = carrosRepository;
    }

    public Carros findById(Long id) throws CarrosException {
        Optional<Carros> carroOptional = carrosRepository.findById(id);
        return carroOptional.orElseThrow(() -> new CarrosException(ID_NOT_FOUND));
    }


    public Page<Carros> findAll(Pageable pageable) {
        List<Carros> carrosList = carrosRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), carrosList.size());
        return new PageImpl<>(carrosList.subList(start, end), pageable, carrosList.size());
    }

    public void deleteById(Long id) {
        carrosRepository.deleteById(id);
    }

    public Carros update(Carros carro) {
        // Verificar se o carro existe no banco de dados
        if (!carrosRepository.existsById(carro.getId())) {
            throw new IllegalArgumentException("Carro não encontrado");
        }
        return carrosRepository.save(carro);
    }

    public Carros save(Carros carro) {
        return carrosRepository.save(carro);
    }

    public boolean existsById(Long id) {
        return carrosRepository.existsById(id);
    }
}
