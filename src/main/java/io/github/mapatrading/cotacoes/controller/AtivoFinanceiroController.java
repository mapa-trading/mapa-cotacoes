package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.AtivoFinanceiro;
import io.github.mapatrading.cotacoes.enums.TipoAtivoFinanceiro;
import io.github.mapatrading.cotacoes.repository.AtivoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"ativos-financeiros"})
public class AtivoFinanceiroController {

    @Autowired
    private AtivoFinanceiroRepository ativoFinanceiroRepository;

    @GetMapping
    public ResponseEntity<List<AtivoFinanceiro>> getAll() {
        List<AtivoFinanceiro> ativosFinanceiros = ativoFinanceiroRepository.findAll();

        return new ResponseEntity<>(ativosFinanceiros, OK);
    }

    @GetMapping("{sigla}")
    public ResponseEntity<AtivoFinanceiro> get(@PathVariable String sigla) {
        AtivoFinanceiro ativoFinanceiro = ativoFinanceiroRepository.findAtivoFinanceiroBySigla(sigla);

        return new ResponseEntity<>(ativoFinanceiro, OK);
    }

    @GetMapping("tipos/{tipo}")
    public ResponseEntity<List<AtivoFinanceiro>> getAllByTipo(@PathVariable TipoAtivoFinanceiro tipo) {
        List<AtivoFinanceiro> ativosFinanceiros = ativoFinanceiroRepository.findAll()
                .stream()
                .filter(ativoFinanceiro -> ativoFinanceiro.getTipoAtivo() == tipo)
                .collect(Collectors.toList());

        return new ResponseEntity<>(ativosFinanceiros, OK);
    }
}
