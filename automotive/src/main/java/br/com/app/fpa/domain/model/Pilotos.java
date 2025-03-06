package br.com.app.fpa.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@ToString
@Table(schema = "fpa", name = "TBPILOTO")
@NoArgsConstructor
public class Pilotos implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "SITUACAO", nullable = false)
    private boolean situacao;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SOBRENOME", nullable = false)
    private String sobreNome;

    @ManyToOne
    @JoinColumn(name = "TIPO_PESSOA_ID")
    private TipoPessoa tipoPessoa;

    @Column(name = "IDENTIDADE", nullable = false, length = 11)
    private String identidade;

    @Column(name = "HABILITACAO", nullable = false, length = 9)
    private String habilitacao;

    @Column(name = "GENERO", nullable = false)
    private String genero;

    @Column(name = "TIPOSANGUINEO", nullable = false)
    private String fatorH;

    @Column(name = "DATANASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "DDD", nullable = false)
    private Integer ddd;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "WHATSAPP", nullable = false)
    private boolean contatoWatsApp;

    @Column(name = "TELEFONEWHATSAPP")
    private String telefoneWhatsapp;

    @ManyToOne
    @JoinColumn(name = "ENDERECO_ID", nullable = false)
    private Endereco endereco;

    @Column(name = "UFFILIACAO", nullable = false)
    private String ufFiliacao;

    @Column(name = "CONTATOREPONSAVEL", nullable = false)
    private String contatoResponsavel;

    @Column(name = "DATAATUALIZACAO")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

}
