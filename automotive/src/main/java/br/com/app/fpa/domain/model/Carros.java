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
@Table(schema = "fpa", name = "TBCARRO")
@NoArgsConstructor
public class Carros implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MARCA", nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID", nullable = false)
    private Categoria categoria;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @Column(name = "ANO", nullable = false, length = 4)
    private Integer ano;

    @Column(name = "UNIDADEFRABRICACAOANO", nullable = false)
    private Integer unidadesFabricadaAno;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "COR", nullable = false)
    private String cor;

    @Column(name = "DATAATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao = LocalDateTime.now();
}
