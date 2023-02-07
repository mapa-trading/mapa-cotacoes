package io.github.mapatrading.cotacoes.controller;


import io.github.mapatrading.cotacoes.entity.Acao;
import io.github.mapatrading.cotacoes.entity.Favorito;
import io.github.mapatrading.cotacoes.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"usuarios/{idUsuario}/favoritos"})
public class FavoritoController {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @GetMapping
    public ResponseEntity<List<Favorito>> get(@PathVariable String idUsuario) {
        //TODO( Fazer o GET para pegar todos os favoritos do usuario)

        return null;
    }

    @PostMapping
    public ResponseEntity<Favorito> post(@PathVariable String idUsuario) {
        // TODO(Adicionar um favorito para o usuario)
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable String id, @PathVariable String idUsuario) {
        // TODO(Deletar um favoriro de um usuario)
        return null;
    }

}
