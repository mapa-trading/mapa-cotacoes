package io.github.mapatrading.cotacoes.controller;


import io.github.mapatrading.cotacoes.entity.Favorito;
import io.github.mapatrading.cotacoes.repository.AtivoFinanceiroRepository;
import io.github.mapatrading.cotacoes.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"usuarios/{idUsuario}/favoritos"})
public class FavoritoController {

    @Autowired
    private FavoritoRepository favoritoRepository;
    @Autowired
    private AtivoFinanceiroRepository ativoFinanceiroRepository;

    @GetMapping
    public ResponseEntity<List<Favorito>> get(@PathVariable UUID idUsuario) {
        List<Favorito> favoritos = favoritoRepository.findAllByIdUsuario(idUsuario);

        return new ResponseEntity<>(favoritos, OK);
    }

    @PostMapping
    public ResponseEntity<Favorito> post(@PathVariable UUID idUsuario, @Valid @RequestBody String sigla) {
        Favorito favorito = new Favorito(ativoFinanceiroRepository.findAtivoFinanceiroBySigla(sigla), idUsuario);

        favoritoRepository.save(favorito);
        return new ResponseEntity<>(favorito, OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<Favorito> favorito = favoritoRepository.findById(id);
        if (favorito.isPresent()) {
            favoritoRepository.delete(favorito.get());
            return new ResponseEntity<>(OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }
}
