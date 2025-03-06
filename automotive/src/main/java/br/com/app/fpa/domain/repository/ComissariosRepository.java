package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.Comissarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComissariosRepository extends JpaRepository<Comissarios, Long> {
}