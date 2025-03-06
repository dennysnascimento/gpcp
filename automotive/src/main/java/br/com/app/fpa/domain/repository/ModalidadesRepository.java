package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.Modalidades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadesRepository extends JpaRepository<Modalidades, Long> {
}