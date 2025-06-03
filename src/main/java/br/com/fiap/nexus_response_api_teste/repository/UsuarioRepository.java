package br.com.fiap.nexus_response_api_teste.repository;

import br.com.fiap.nexus_response_api_teste.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);

}
