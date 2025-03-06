package br.com.app.fpa.domain.service;

import br.com.app.fpa.domain.exceptions.CarrosException;
import br.com.app.fpa.domain.exceptions.CategoriaException;
import br.com.app.fpa.domain.model.Categoria;
import br.com.app.fpa.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.app.fpa.domain.enums.MensagensErroEnum.ID_NOT_FOUND;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria findById(Long id) throws CategoriaException {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.orElseThrow(() -> new CategoriaException(ID_NOT_FOUND));
    }

    public Page<Categoria> findAll(Pageable pageable) {
        List<Categoria> categoriasList = categoriaRepository.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), categoriasList.size());
        return new PageImpl<>(categoriasList.subList(start, end), pageable, categoriasList.size());
    }

    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria update(Categoria categoria) {
        // Verificar se a categoria existe no banco de dados
        if (!categoriaRepository.existsById(categoria.getId())) {
            throw new IllegalArgumentException("Categoria não encontrada");
        }
        return categoriaRepository.save(categoria);
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public boolean existsById(Long id) {
        return categoriaRepository.existsById(id);
    }
}
