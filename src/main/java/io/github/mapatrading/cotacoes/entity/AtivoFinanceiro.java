package io.github.mapatrading.cotacoes.entity;

import io.github.mapatrading.cotacoes.enums.TipoAtivoFinanceiro;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AtivoFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sigla", nullable = false)
    private String sigla;
    @Column(name = "moeda", nullable = false)
    private String moeda;

    public TipoAtivoFinanceiro getTipoAtivo() {

        TipoAtivoFinanceiro tipo;

        if (this instanceof Acao) tipo = TipoAtivoFinanceiro.ACAO;
        else if (this instanceof Crypto) tipo = TipoAtivoFinanceiro.CRYPTO;
        else tipo = TipoAtivoFinanceiro.MOEDA;

        return tipo;
    }
}
