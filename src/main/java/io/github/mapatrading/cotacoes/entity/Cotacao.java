package io.github.mapatrading.cotacoes.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Table(name = "cotacao")
@Entity
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ativo_financeiro", foreignKey = @ForeignKey(name = "fk_ativo_financeiro"), nullable = false)
    private AtivoFinanceiro ativoFinanceiro;
    @Column(name = "data_hora", nullable = false)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dataHora;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    public Cotacao(AtivoFinanceiro ativoFinanceiro, LocalDateTime dataHora, BigDecimal valor) {
        setAtivoFinanceiro(ativoFinanceiro);
        setDataHora(dataHora);
        setValor(valor);
    }

    public Cotacao() {
    }

    public CotacaoRequest toCotacaoRequest() {
        return new CotacaoRequest(getAtivoFinanceiro().getTipoAtivo(), getAtivoFinanceiro().getSigla(), getDataHora(), getValor());
    }

    public Boolean isBetween(BigDecimal valor1, BigDecimal valor2) {
        return getValor().compareTo(valor1) >= 0 && getValor().compareTo(valor2) <= 0;
    }
}


