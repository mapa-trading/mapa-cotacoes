package io.github.mapatrading.cotacoes.controller;


import io.github.mapatrading.cotacoes.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Get() {

        emailService.sendEmail("alanviana.nascimento@gmail.com", "opa", "test");

        return "Hello World";
    }

}
