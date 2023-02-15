package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.AtivoFinanceiro;
import io.github.mapatrading.cotacoes.entity.Favorito;
import io.github.mapatrading.cotacoes.entity.Notificacao;
import io.github.mapatrading.cotacoes.entity.NotificacaoRequest;
import io.github.mapatrading.cotacoes.repository.AtivoFinanceiroRepository;
import io.github.mapatrading.cotacoes.repository.CotacaoRepository;
import io.github.mapatrading.cotacoes.repository.FavoritoRepository;
import io.github.mapatrading.cotacoes.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"usuarios/{idUsuario}/notificacoes"})
public class NotificacaoController {

    @Autowired
    private NotificacaoRepository notificacaoRepository;
    @Autowired
    private AtivoFinanceiroRepository ativoFinanceiroRepository;

    @Autowired
    private CotacaoRepository cotacaoRepository;


    @GetMapping
    public ResponseEntity<List<Notificacao>> get(@PathVariable UUID idUsuario) {
        List<Notificacao> notificacoes = notificacaoRepository.findAllByIdUsuario(idUsuario);

        return new ResponseEntity<>(notificacoes, OK);
    }

    @PostMapping
    public ResponseEntity<Notificacao> post(@PathVariable UUID idUsuario, @Valid @RequestBody NotificacaoRequest notificacaoRequest) {
        AtivoFinanceiro ativoFinanceiro = ativoFinanceiroRepository.findAtivoFinanceiroBySigla(notificacaoRequest.getSigla());
        Notificacao notificacao = new Notificacao(
                idUsuario,
                ativoFinanceiro,
                cotacaoRepository.findByAtivoFinanceiroOrderByDataHoraAsc(ativoFinanceiro).getValor(),
                notificacaoRequest.getValorMaximo(),
                notificacaoRequest.getValorMinimo()
        );

        notificacaoRepository.save(notificacao);
        return new ResponseEntity<>(notificacao, OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<Notificacao> notificacao = notificacaoRepository.findById(id);
        if (notificacao.isPresent()) {
            notificacaoRepository.delete(notificacao.get());
            return new ResponseEntity<>(OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Notificacao> editar(@PathVariable UUID id, @RequestBody NotificacaoRequest notificacaoRequest) {

        Optional<Notificacao> notificacao = notificacaoRepository.findById(id);

        if (notificacao.isPresent()) {
            notificacaoRepository.updateValorMaximoAndValorMinimoById(notificacaoRequest.getValorMaximo(), notificacaoRequest.getValorMinimo(), notificacao.get().getId());
            return new ResponseEntity<>(OK);
        } else return new ResponseEntity<>(NOT_FOUND);

    }
}
