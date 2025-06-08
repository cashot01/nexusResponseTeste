package br.com.fiap.nexus_response_api_teste.repository;

import br.com.fiap.nexus_response_api_teste.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<UserDetails> findByEmail(String email);
    Optional<Usuario> findUsuarioByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}

