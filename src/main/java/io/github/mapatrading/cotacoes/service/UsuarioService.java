package io.github.mapatrading.cotacoes.service;

import io.github.mapatrading.cotacoes.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class UsuarioService {

    @Value("${URL_MAPA_CONTA:http://localhost:8090}")
    private String urlMapaConta;


    public Usuario getUsuarioById(UUID idUsuario) {
        String uri = "/usuario/{idUsuario}";

        return WebClient.create(urlMapaConta).get().uri(uri, idUsuario.toString()).retrieve().bodyToMono(Usuario.class).block();
    }

}
