package br.com.fiap.nexus_response_api_teste.controller;

import br.com.fiap.nexus_response_api_teste.model.NivelUrgencia;
import br.com.fiap.nexus_response_api_teste.repository.NivelUrgenciaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/nivelUrgencia")
@Slf4j
public class NivelUrgenciaController {

    @Autowired
    private NivelUrgenciaRepository repository;

    @GetMapping
    @Cacheable("nivelUrgencia")
    @Operation(description = "Listar todos os níveis de urgência", tags = "nivelUrgencia", summary = "Lista de níveis de urgência")
    public List<NivelUrgencia> index() {
        log.info("Buscando todos os níveis de urgência");
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "urgencyLevels", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(responseCode = "400", description = "Falha na validação")
    })
    public NivelUrgencia create(@RequestBody @Valid NivelUrgencia nivel) {
        log.info("Cadastrando nível de urgência: " + nivel.getDescricaoNivel());
        return repository.save(nivel);
    }

    @GetMapping("{id}")
    public NivelUrgencia get(@PathVariable Long id) {
        log.info("Buscando nível de urgência com ID: " + id);
        return getNivelUrgencia(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando nível de urgência com ID: " + id);
        repository.delete(getNivelUrgencia(id));
    }

    @PutMapping("{id}")
    public NivelUrgencia update(@PathVariable Long id, @RequestBody @Valid NivelUrgencia nivel) {
        log.info("Atualizando nível de urgência com ID: " + id + " - Nova descrição: " + nivel.getDescricaoNivel());
        nivel.setIdNivelUrgencia(id);
        return repository.save(nivel);
    }

    private NivelUrgencia getNivelUrgencia(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nível de urgência não encontrado"));
    }
}
