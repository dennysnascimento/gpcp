package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.TipoComissario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoComissarioRepository extends JpaRepository<TipoComissario, Long> {
}