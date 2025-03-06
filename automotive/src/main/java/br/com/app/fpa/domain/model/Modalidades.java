package br.com.app.fpa.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@ToString
@Table(schema = "fpa", name = "TBMODALIDADE")
@NoArgsConstructor
public class Modalidades implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DATAATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

}
