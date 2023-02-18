package io.github.mapatrading.cotacoes.repository;

import io.github.mapatrading.cotacoes.entity.AtivoFinanceiro;
import io.github.mapatrading.cotacoes.entity.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, UUID> {
    @Query("select c from Cotacao c where c.ativoFinanceiro = ?1 order by c.dataHora")
    List<Cotacao> findByAtivoFinanceiroOrderByDataHoraAsc(AtivoFinanceiro ativoFinanceiro);

    List<Cotacao> findAllByAtivoFinanceiroAndDataHoraBetween(AtivoFinanceiro ativoFinanceiro, LocalDateTime dataHora, LocalDateTime dataHora2);

    //Cotacao findFirstByAtivoFinanceiroAndOrderByDataHora(AtivoFinanceiro ativoFinanceiro);
}
