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
@Table(schema = "fpa", name = "TBPROMOTORES")
@NoArgsConstructor

public class Promotores implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "situacao", nullable = false)
    private boolean situacao;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column( name= "cpf", nullable = false ,length = 11)
    private String cpf;

    @Column( name= "cnpj", nullable = false ,length = 14)
    private String cnpj;

    @Column(name = "codigopais", nullable = false)
    private int codigoPais;

    @Column(name = "DDD", nullable = false)
    private int ddd;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "contatowattsapp", nullable = false)
    private boolean contatoWattsApp ;

    @Column(name = "contatoresponsavel", nullable = false)
    private String contatoResponsavel;

    @Column(name = "dataatualizacao")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

}
