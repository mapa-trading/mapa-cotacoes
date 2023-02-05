package io.github.mapatrading.cotacoes.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Crypto extends AtivoFinanceiro {
    @Column(name = "imagem_url", nullable = false)
    private String imagemUrl;
    @Column(name = "moeda", nullable = false)
    private String moeda;
}
