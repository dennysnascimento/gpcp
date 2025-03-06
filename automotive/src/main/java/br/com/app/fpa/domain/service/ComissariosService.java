package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.exceptions.CarrosException;
import br.com.app.fpa.domain.exceptions.ComissariosException;
import br.com.app.fpa.domain.model.Comissarios;
import br.com.app.fpa.domain.repository.ComissariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class ComissariosService {

    private final ComissariosRepository comissariosRepository;

    @Autowired
    public ComissariosService(ComissariosRepository comissariosRepository) {
        this.comissariosRepository = comissariosRepository;
    }

    public Comissarios findById(Long id) throws ComissariosException {
        Optional<Comissarios> comissarioOptional = comissariosRepository.findById(id);
        return comissarioOptional.orElseThrow(() -> new ComissariosException(ID_NOT_FOUND));
    }

    public Page<Comissarios> findAll(Pageable pageable) {
        List<Comissarios> comissariosList = comissariosRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), comissariosList.size());
        return new PageImpl<>(comissariosList.subList(start, end), pageable, comissariosList.size());
    }

    public void deleteById(Long id) {
        comissariosRepository.deleteById(id);
    }

    public Comissarios update(Comissarios comissario) {
        // Verificar se o comissario existe no banco de dados
        if (!comissariosRepository.existsById(comissario.getId())) {
            throw new IllegalArgumentException("Comissario não encontrado");
        }
        return comissariosRepository.save(comissario);
    }

    public Comissarios save(Comissarios comissario) {
        return comissariosRepository.save(comissario);
    }

    public boolean existsById(Long id) {
        return comissariosRepository.existsById(id);
    }
}
