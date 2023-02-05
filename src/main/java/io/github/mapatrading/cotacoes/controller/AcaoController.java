package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.Acao;
import io.github.mapatrading.cotacoes.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"acao"})
public class AcaoController {

    @Autowired
    private AcaoRepository acaoRepository;

    @PostMapping
    public Acao Post(@Valid @RequestBody Acao pessoa, HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        // TODO(APlicar autorização JWT)
        System.out.println("Authorization: " + authorization);

        return acaoRepository.save(pessoa);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") UUID id) {
        Optional<Acao> pessoa = acaoRepository.findById(id);
        if (pessoa.isPresent()) {
            acaoRepository.delete(pessoa.get());
            return new ResponseEntity<>(OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }

}
