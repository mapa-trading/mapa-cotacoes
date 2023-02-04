package io.github.mapatrading.cotacoes.controller;


import javax.validation.Valid;

import io.github.mapatrading.cotacoes.entity.Acao;
import io.github.mapatrading.cotacoes.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/acao"})
public class AcaoController {

    AcaoRepository acaoRepository;

    @PostMapping
    public Acao create(@RequestBody Acao acao) {
        return acaoRepository.save(acao);
    }
}
