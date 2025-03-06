package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.Carros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<Carros, Long> {

}