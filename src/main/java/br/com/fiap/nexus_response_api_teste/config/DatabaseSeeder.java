package br.com.fiap.nexus_response_api_teste.config;

import br.com.fiap.nexus_response_api_teste.model.Usuario;
import br.com.fiap.nexus_response_api_teste.model.UsuarioPapel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        var cauan = Usuario.builder()
                .email("cauan@gmail.com")
                .senha(passwordEncoder.encode("12345"))
                .papel(UsuarioPapel.ADM)
                .cpf(12345678900)
                .nome("Cauan")
                .build();
    }
}
