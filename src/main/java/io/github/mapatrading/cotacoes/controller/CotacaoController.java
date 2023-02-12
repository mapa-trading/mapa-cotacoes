package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.AtivoFinanceiro;
import io.github.mapatrading.cotacoes.entity.Cotacao;
import io.github.mapatrading.cotacoes.entity.CotacaoRequest;
import io.github.mapatrading.cotacoes.repository.AtivoFinanceiroRepository;
import io.github.mapatrading.cotacoes.repository.CotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"cotacoes"})
public class CotacaoController {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Autowired
    private AtivoFinanceiroRepository ativoFinanceiroRepository;

    @PostMapping
    public ResponseEntity<CotacaoRequest> post(@RequestBody CotacaoRequest request) {
        System.out.println("--------------------");
        System.out.println(request);
        System.out.println("--------------------");

        AtivoFinanceiro ativoFinanceiro = ativoFinanceiroRepository.findAtivoFinanceiroBySigla(request.getSigla());

        if (ativoFinanceiro != null) {
            Cotacao cotacao = new Cotacao(ativoFinanceiro, request.getDataHora(), request.getValor());
            cotacaoRepository.save(cotacao);
            return new ResponseEntity<>(cotacao.toCotacaoRequest(), OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<CotacaoRequest>> get(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam List<String> siglas
    ) {

        List<Cotacao> cotacoes = new ArrayList<>();

        for (String sigla : siglas) {
            final AtivoFinanceiro ativoFinanceiro = ativoFinanceiroRepository.findAtivoFinanceiroBySigla(sigla);
            final List<Cotacao> cotacoesByAtivo = cotacaoRepository.findAllByAtivoFinanceiroAndDataHoraBetween(
                    ativoFinanceiro,
                    startDate.atTime(0, 0),
                    endDate.atTime(23, 59)
            );
            cotacoes.addAll(cotacoesByAtivo);
        }

        List<CotacaoRequest> cotacoesResquest = cotacoes.stream().map(Cotacao::toCotacaoRequest).collect(Collectors.toList());

        return new ResponseEntity<>(cotacoesResquest, OK);
    }
}
