package io.github.mapatrading.cotacoes.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mapatrading.cotacoes.enums.TipoAtivoFinanceiro;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CotacaoRequest {

    private TipoAtivoFinanceiro tipo;
    private String sigla;
    private LocalDateTime dataHora;
    private BigDecimal valor;

    public CotacaoRequest(TipoAtivoFinanceiro tipo, String sigla, LocalDateTime dataHora, BigDecimal valor) {
        setTipo(tipo);
        setSigla(sigla);
        setDataHora(dataHora);
        setValor(valor);
    }
}
