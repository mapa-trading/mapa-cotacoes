package io.github.mapatrading.cotacoes.repository;

import io.github.mapatrading.cotacoes.entity.Favorito;
import io.github.mapatrading.cotacoes.entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, UUID> {
    @Transactional
    @Modifying
    @Query("update Notificacao n set n.valorMaximo = ?1, n.valorMinimo = ?2 where n.id = ?3")
    void updateValorMaximoAndValorMinimoById(BigDecimal valorMaximo, BigDecimal valorMinimo, UUID id);

    List<Notificacao> findAllByIdUsuario(UUID idUsuario);
}
