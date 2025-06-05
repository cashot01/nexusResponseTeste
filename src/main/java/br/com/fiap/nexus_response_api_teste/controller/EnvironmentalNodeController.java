package br.com.fiap.nexus_response_api_teste.controller;

import br.com.fiap.nexus_response_api_teste.model.EnvironmentalNode;
import br.com.fiap.nexus_response_api_teste.repository.EnvironmentalNodeRepository;
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
@RequestMapping("/environmental-nodes")
@Slf4j
public class EnvironmentalNodeController {

    @Autowired
    private EnvironmentalNodeRepository repository;

    @GetMapping
    @Cacheable("environmentalNodes")
    @Operation(description = "Listar todos os Environmental Node", tags = "environmental-nodes", summary = "Lista dos Environmentals Node")
    public List<EnvironmentalNode> index() {
        log.info("Buscando todos os nós ambientais");
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "environmentalNodes", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(responseCode = "400", description = "Falha na validação")
    })
    public EnvironmentalNode create(@RequestBody @Valid EnvironmentalNode node) {
        log.info("Cadastrando nó ambiental com temperatura média: " + node.getTempMedia());
        return repository.save(node);
    }

    @GetMapping("{id}")
    public EnvironmentalNode get(@PathVariable Long id) {
        log.info("Buscando nó ambiental com ID: " + id);
        return getNode(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando nó ambiental com ID: " + id);
        repository.delete(getNode(id));
    }

    @PutMapping("{id}")
    public EnvironmentalNode update(@PathVariable Long id, @RequestBody @Valid EnvironmentalNode node) {
        log.info("Atualizando nó ambiental com ID: " + id + " - Nova temperatura média: " + node.getTempMedia());
        node.setIdEnvironmentalNode(id);
        return repository.save(node);
    }

    private EnvironmentalNode getNode(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nó ambiental não encontrado"));
    }
}