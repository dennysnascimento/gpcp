package br.com.app.fpa.domain.repository;

import br.com.app.fpa.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}