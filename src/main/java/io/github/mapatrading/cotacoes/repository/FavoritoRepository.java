package io.github.mapatrading.cotacoes.repository;

import io.github.mapatrading.cotacoes.entity.Favorito;
import io.github.mapatrading.cotacoes.entity.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, UUID> {
    List<Favorito> findAllByIdUsuario(UUID idUsuario);
}
