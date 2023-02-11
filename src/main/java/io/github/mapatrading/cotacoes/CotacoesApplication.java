package io.github.mapatrading.cotacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CotacoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CotacoesApplication.class, args);
    }

}
