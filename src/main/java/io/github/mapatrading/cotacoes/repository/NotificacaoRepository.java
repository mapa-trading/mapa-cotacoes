package io.github.mapatrading.cotacoes.repository;

import io.github.mapatrading.cotacoes.entity.Favorito;
import io.github.mapatrading.cotacoes.entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, UUID> {
}
