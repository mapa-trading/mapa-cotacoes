package io.github.mapatrading.cotacoes.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private Boolean receberNotificacoesEmail;
    private Boolean receberNotificacoesWhatsApp;
    private Boolean recerberNotificacoesDispositivo;
}
