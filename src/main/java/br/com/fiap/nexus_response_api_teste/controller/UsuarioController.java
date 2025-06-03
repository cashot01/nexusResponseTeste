package br.com.fiap.nexus_response_api_teste.controller;

import br.com.fiap.nexus_response_api_teste.model.Usuario;
import br.com.fiap.nexus_response_api_teste.model.UsuarioPapel;

import br.com.fiap.nexus_response_api_teste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        usuario.setPapel(UsuarioPapel.USUARIO);
        return repository.save(usuario);
    }

}

