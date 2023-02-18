package io.github.mapatrading.cotacoes.service;

import io.github.mapatrading.cotacoes.entity.Cotacao;
import io.github.mapatrading.cotacoes.entity.Notificacao;
import io.github.mapatrading.cotacoes.entity.Usuario;
import io.github.mapatrading.cotacoes.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    @Autowired
    EmailService emailService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    NotificacaoRepository notificacaoRepository;

    public void enviaNotificacao(Cotacao cotacao) {

        notificacaoRepository.findAll().stream()
                .filter(notificacao -> cotacao.isBetween(notificacao.getValorMinimo(), notificacao.getValorMaximo()) && !notificacao.getNotificado())
                .forEach(notificacao -> {
                    notificacao.setNotificado(true);
                    notificacaoRepository.save(notificacao);

                    final Usuario usuario = usuarioService.getUsuarioById(notificacao.getIdUsuario());
                    emailService.enviaEmailCotacao(usuario, cotacao);
                });
    }
}
