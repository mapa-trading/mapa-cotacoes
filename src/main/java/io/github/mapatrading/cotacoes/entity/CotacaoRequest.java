package io.github.mapatrading.cotacoes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.github.mapatrading.cotacoes.enums.TipoAtivoFinanceiro;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CotacaoRequest {

    private TipoAtivoFinanceiro tipo;
    private String sigla;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime dataHora;
    private BigDecimal valor;

    public CotacaoRequest(){
    }

    public CotacaoRequest(TipoAtivoFinanceiro tipo, String sigla, LocalDateTime dataHora, BigDecimal valor) {
        setTipo(tipo);
        setSigla(sigla);
        setDataHora(dataHora);
        setValor(valor);
    }
}
