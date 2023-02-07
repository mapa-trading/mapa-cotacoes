package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.Favorito;
import io.github.mapatrading.cotacoes.repository.FavoritoRepository;
import io.github.mapatrading.cotacoes.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"usuarios/{idUsuario}/notificacoes"})
public class NotificacaoController {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @GetMapping
    public ResponseEntity<List<Favorito>> get(@PathVariable String idUsuario) {
        //TODO( Fazer o GET para pegar todas as configuracoes de notificacoes do usuario)

        return null;
    }

    @PostMapping
    public ResponseEntity<Favorito> post(@PathVariable String idUsuario) {
        // TODO(Adicionar uma configuracao de notificacao para o usuario)
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable String id, @PathVariable String idUsuario) {
        // TODO(Deletar uma configuracao de notificacao de um usuario)
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<Favorito> editar(@PathVariable String id, @PathVariable String idUsuario) {
        return null;
    }

}
