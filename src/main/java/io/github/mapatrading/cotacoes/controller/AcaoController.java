package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.Acao;
import io.github.mapatrading.cotacoes.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"acoes"})
public class AcaoController {

    @Autowired
    private AcaoRepository acaoRepository;

    @PostMapping
    public ResponseEntity<Acao> post(@Valid @RequestBody Acao acao, HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        // TODO(APlicar autorização JWT)
        System.out.println("Authorization: " + authorization);
        acaoRepository.save(acao);
        return new ResponseEntity<>(acao, OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<Acao> acao = acaoRepository.findById(id);
        if (acao.isPresent()) {
            acaoRepository.delete(acao.get());
            return new ResponseEntity<>(OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }
}
