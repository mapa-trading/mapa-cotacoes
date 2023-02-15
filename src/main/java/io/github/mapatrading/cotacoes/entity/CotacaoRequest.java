package io.github.mapatrading.cotacoes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.github.mapatrading.cotacoes.enums.TipoAtivoFinanceiro;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CotacaoRequest {

    private TipoAtivoFinanceiro tipo;
    @NotBlank(message = "É necessário informar a sigla")
    private String sigla;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotBlank(message = "É necessário informar a data e hora no formato yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataHora;
    @NotBlank(message = "É necessário informar o valor")
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
