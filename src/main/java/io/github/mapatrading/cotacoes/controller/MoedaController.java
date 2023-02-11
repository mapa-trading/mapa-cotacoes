package io.github.mapatrading.cotacoes.controller;

import io.github.mapatrading.cotacoes.entity.Moeda;
import io.github.mapatrading.cotacoes.repository.MoedaRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping({"moedas"})
public class MoedaController {

    @Autowired
    private MoedaRepository moedaRepository;

    @ApiOperation(value = "Adiciona um ativo financeiro do tipo Moeda")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Uma moeda foi incluida com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Moeda> post(@Valid @RequestBody Moeda Moeda, HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        // TODO(APlicar autorização JWT)
        System.out.println("Authorization: " + authorization);
        moedaRepository.save(Moeda);
        return new ResponseEntity<>(Moeda, OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<Moeda> Moeda = moedaRepository.findById(id);
        if (Moeda.isPresent()) {
            moedaRepository.delete(Moeda.get());
            return new ResponseEntity<>(OK);
        } else return new ResponseEntity<>(NOT_FOUND);
    }
}
