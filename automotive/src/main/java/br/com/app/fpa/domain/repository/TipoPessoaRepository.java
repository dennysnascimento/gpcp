package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.TipoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Long> {
}