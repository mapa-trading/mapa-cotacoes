package io.github.mapatrading.cotacoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Entity
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "id_usuario", nullable = false)
    private UUID idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_ativo_financeiro", foreignKey = @ForeignKey(name = "fk_ativo_financeiro"), nullable = false)
    private AtivoFinanceiro ativoFinanceiro;

    public Favorito(AtivoFinanceiro ativoFinanceiro, UUID idUsuario) {
        setAtivoFinanceiro(ativoFinanceiro);
        setIdUsuario(idUsuario);
    }

    public Favorito() {
    }

}
