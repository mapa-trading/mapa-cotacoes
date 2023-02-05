package io.github.mapatrading.cotacoes.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@Entity
public class Acao extends AtivoFinanceiro {
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "razaoSocial", nullable = false)
    private String razaoSocial;

    @Column(name = "website", nullable = false)
    private String website;
}
