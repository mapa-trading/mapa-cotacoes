package io.github.mapatrading.cotacoes.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class NotificacaoRequest {

    @NotBlank(message = "É necessário informar a sigla")
    private String sigla;

    @ApiModelProperty(value = "Um valor para mínimo para ser notificado")
    @NotBlank(message = "É necessário informar o valor maáximo")
    private BigDecimal valorMaximo;

    @ApiModelProperty(value = "Um valor para máximo para ser notificado")
    @NotBlank(message = "É necessário informar o valor minimo")
    private BigDecimal valorMinimo;


    public NotificacaoRequest() {
    }

    public NotificacaoRequest(String sigla, BigDecimal valorMaximo, BigDecimal valorMinimo) {
        setSigla(sigla);
        setValorMaximo(valorMaximo);
        setValorMinimo(valorMinimo);
    }
}
