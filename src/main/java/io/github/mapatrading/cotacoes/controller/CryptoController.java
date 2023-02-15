package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.Crypto;
import io.github.mapatrading.cotacoes.repository.CryptoRepository;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping({"cryptos"})
public class CryptoController {

    @Autowired
    private CryptoRepository cryptoRepository;

    @PostMapping
    public ResponseEntity<Crypto> post(@Valid @RequestBody Crypto crypto, HttpServletRequest request) {
        cryptoRepository.save(crypto);
        return new ResponseEntity<>(crypto, OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Crypto> get(@PathVariable UUID id) {
        Optional<Crypto> crypto = cryptoRepository.findById(id);

        if (crypto.isPresent()){
            return new ResponseEntity<>(crypto.get(), OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<Crypto> crypto = cryptoRepository.findById(id);
        if (crypto.isPresent()) {
            cryptoRepository.delete(crypto.get());
            return new ResponseEntity<>(OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Crypto> edit(@PathVariable(value = "id") UUID id, @Valid @RequestBody Crypto newCrypto) {
        Optional<Crypto> oldAcao = cryptoRepository.findById(id);

        if(oldAcao.isPresent()){
            Crypto crypto = oldAcao.get();
            crypto.setNome(newCrypto.getNome());
            crypto.setSigla (newCrypto.getSigla());
            crypto.setImagemUrl(newCrypto.getImagemUrl());
            crypto.setMoeda(newCrypto.getMoeda());
            cryptoRepository.save(crypto);
            return new ResponseEntity<>(crypto, OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }
}
