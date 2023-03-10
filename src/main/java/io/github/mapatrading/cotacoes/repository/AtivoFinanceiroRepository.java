package io.github.mapatrading.cotacoes.repository;

import io.github.mapatrading.cotacoes.entity.AtivoFinanceiro;
import io.github.mapatrading.cotacoes.enums.TipoAtivoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface AtivoFinanceiroRepository extends JpaRepository<AtivoFinanceiro, UUID> {

    AtivoFinanceiro findAtivoFinanceiroBySigla(String sigla);

}
