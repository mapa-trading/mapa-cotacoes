package io.github.mapatrading.cotacoes.repository;

import io.github.mapatrading.cotacoes.entity.Acao;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, UUID> {
}
