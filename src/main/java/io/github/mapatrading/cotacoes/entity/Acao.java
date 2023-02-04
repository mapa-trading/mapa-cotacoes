package io.github.mapatrading.cotacoes.entity;

import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sigla", nullable = false)
    private String sigla;

    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "razaoSocial", nullable = false)
    private String razaoSocial;
}
