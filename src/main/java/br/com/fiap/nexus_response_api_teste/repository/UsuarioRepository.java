package br.com.fiap.nexus_response_api_teste.repository;

import br.com.fiap.nexus_response_api_teste.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByEmail(String username);
}
