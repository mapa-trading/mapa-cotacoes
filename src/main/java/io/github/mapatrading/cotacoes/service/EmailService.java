package io.github.mapatrading.cotacoes.service;

import io.github.mapatrading.cotacoes.entity.Cotacao;
import io.github.mapatrading.cotacoes.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String destinatario, String assunto, String conteudo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destinatario);
        message.setSubject(assunto);
        message.setText(conteudo);

        mailSender.send(message);
    }

    void enviaEmailCotacao(Usuario usuario, Cotacao cotacao) {

        String conteudo = "Olá " + usuario.getNome() + ". Boa notícia para você!!\n\n" +
                "Sabe a cotação " + cotacao.getAtivoFinanceiro().getSigla() + "? \n" +
                "Pois é, ela está cotada nesse momento em R$ " + cotacao.getValor() + "!!!\n" +
                "Te notificamos, conforme você definiu no App MAPA-Trading!\n\n" +
                "Tenha um ótimo dia";

        sendEmail(usuario.getEmail(), "Notificacao da Cotacao" + cotacao.getAtivoFinanceiro().getSigla(), conteudo);

    }

}