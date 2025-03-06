package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}