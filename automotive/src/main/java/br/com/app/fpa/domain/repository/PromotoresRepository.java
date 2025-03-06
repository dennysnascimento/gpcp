package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.Promotores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotoresRepository extends JpaRepository<Promotores, Long> {
}