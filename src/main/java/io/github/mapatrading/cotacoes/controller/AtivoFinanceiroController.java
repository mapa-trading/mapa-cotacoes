package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.AtivoFinanceiro;
import io.github.mapatrading.cotacoes.repository.AtivoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"ativos-financeiros"})
public class AtivoFinanceiroController {

    @Autowired
    private AtivoFinanceiroRepository ativoFinanceiroRepository;

    @GetMapping("{sigla}")
    public ResponseEntity<AtivoFinanceiro> get(@PathVariable String sigla) {
        AtivoFinanceiro ativoFinanceiro = ativoFinanceiroRepository.findAtivoFinanceiroBySigla(sigla);

        return new ResponseEntity<>(ativoFinanceiro, OK);
    }
}
