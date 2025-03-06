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
@Table(schema = "fpa", name = "TBCOMISSARIO")
@NoArgsConstructor
public class Comissarios implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SOBRENOME", nullable = false)
    private String sobreNome;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "CODIGOPAIS", nullable = false)
    private Integer codigoPais;

    @Column(name = "DDD", nullable = false)
    private Integer ddd;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "UFFILIAL", nullable = false)
    private String ufFilial;

    @Column(name = "SITUACAO", nullable = false)
    private boolean situacao;

    @ManyToOne
    @JoinColumn(name = "TIPO_COMISSARIO_ID", nullable = false)
    private TipoComissario tipoComissario;

    @Column(name = "DATAATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao = LocalDateTime.now();


}
