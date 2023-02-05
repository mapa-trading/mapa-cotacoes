package io.github.mapatrading.cotacoes.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Moeda extends AtivoFinanceiro {
    @Column(name = "origem", nullable = false)
    private String origem;
}
