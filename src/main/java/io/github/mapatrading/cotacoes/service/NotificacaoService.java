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

    /**
     * O sistema pega a cotação e verifica se alguem configurou para receber uma notificação dele
     * A notificação é enviada somente uma vez pois o parametro notificado é ativado
     * A notificação só é enviada se no cadastro do usuário estiver configurado para receber notificação por email
     *
     * @param cotacao
     */
    public void enviaNotificacao(Cotacao cotacao) {

        notificacaoRepository.findAll().stream()
                .filter(notificacao -> cotacao.isBetween(notificacao.getValorMinimo(), notificacao.getValorMaximo()) && !notificacao.getNotificado())
                .forEach(notificacao -> {

                    notificacao.setNotificado(true);
                    notificacaoRepository.save(notificacao);

                    final Usuario usuario = usuarioService.getUsuarioById(notificacao.getIdUsuario());

                    if (usuario.getReceberNotificacoesEmail()) {
                        emailService.enviaEmailCotacao(usuario, cotacao);
                    }
                });
    }
}
