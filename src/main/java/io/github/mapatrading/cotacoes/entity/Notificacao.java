package io.github.mapatrading.cotacoes.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "id_usuario", nullable = false)
    private UUID idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_ativo_financeiro", foreignKey = @ForeignKey(name = "fk_ativo_financeiro"), nullable = false)
    private AtivoFinanceiro ativoFinanceiro;
    @Column(name = "valor_atual", nullable = false)
    private BigDecimal valorAtual;

    @ApiModelProperty(value = "Um valor para mínimo para ser notificado")
    @Column(name = "valor_maximo", nullable = false)
    private BigDecimal valorMaximo;

    @ApiModelProperty(value = "Um valor para máximo para ser notificado")
    @Column(name = "valor_minimo", nullable = false)
    private BigDecimal valorMinimo;
    @Column(name = "notificado", nullable = false)
    private Boolean notificado;

    public Notificacao() {
    }

    public Notificacao(UUID idUsuario, AtivoFinanceiro ativoFinanceiro, BigDecimal valorAtual, BigDecimal valorMaximo, BigDecimal valorMinimo) {
        setIdUsuario(idUsuario);
        setAtivoFinanceiro(ativoFinanceiro);
        setValorAtual(valorAtual);
        setValorMaximo(valorMaximo);
        setValorMinimo(valorMinimo);
        setNotificado(Boolean.FALSE);
    }
}
