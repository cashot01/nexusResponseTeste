package br.com.fiap.nexus_response_api_teste.controller;

import br.com.fiap.nexus_response_api_teste.model.LocationTracker;
import br.com.fiap.nexus_response_api_teste.repository.LocationTrackerRespository;
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
@RequestMapping("/locations")
@Slf4j
public class LocationTrackerController {

    @Autowired
    private LocationTrackerRespository repository;

    @GetMapping
    @Cacheable("locations")
    @Operation(description = "Listar todos Location Trackers", tags = "locations", summary = "Lista dos Location Tracker")
    public List<LocationTracker> index() {
        log.info("Buscando todos os Location Trackers");
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "locations", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(responseCode = "400", description = "Falha na validação")
    })
    public LocationTracker create(@RequestBody @Valid LocationTracker location) {
        log.info("Cadastrando localização com latitude: " + location.getLatitude());
        return repository.save(location);
    }

    @GetMapping("{id}")
    public LocationTracker get(@PathVariable Long id) {
        log.info("Buscando localização com ID: " + id);
        return getLocation(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando localização com ID: " + id);
        repository.delete(getLocation(id));
    }

    @PutMapping("{id}")
    public LocationTracker update(@PathVariable Long id, @RequestBody @Valid LocationTracker location) {
        log.info("Atualizando localização com ID: " + id + " - Nova latitude: " + location.getLatitude());
        location.setIdLocation(id);
        return repository.save(location);
    }

    private LocationTracker getLocation(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Localização não encontrada"));
    }
}
