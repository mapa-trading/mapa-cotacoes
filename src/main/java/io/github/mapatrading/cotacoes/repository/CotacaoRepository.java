package io.github.mapatrading.cotacoes.repository;

import io.github.mapatrading.cotacoes.entity.AtivoFinanceiro;
import io.github.mapatrading.cotacoes.entity.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, UUID> {

    List<Cotacao> findAllByAtivoFinanceiroAndDataHoraBetween(AtivoFinanceiro ativoFinanceiro, LocalDateTime dataHora, LocalDateTime dataHora2);

}
