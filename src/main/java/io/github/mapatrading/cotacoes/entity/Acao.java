package io.github.mapatrading.cotacoes.entity;


import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@Entity
public class Acao extends AtivoFinanceiro {
    @NotNull(message = "É necessário informar uma descrição")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @NotNull(message = "É necessário informar a razão social")
    @Column(name = "razaoSocial", nullable = false)
    private String razaoSocial;
    @Column(name = "website", nullable = false)
    private String website;
}
