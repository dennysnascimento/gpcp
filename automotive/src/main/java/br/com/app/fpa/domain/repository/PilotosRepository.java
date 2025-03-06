package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.Pilotos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotosRepository extends JpaRepository<Pilotos, Long> {
}