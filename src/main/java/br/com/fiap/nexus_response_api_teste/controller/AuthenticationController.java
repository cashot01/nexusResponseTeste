package br.com.fiap.nexus_response_api_teste.controller;

import br.com.fiap.nexus_response_api_teste.config.security.TokenService;
import br.com.fiap.nexus_response_api_teste.model.Usuario;
import br.com.fiap.nexus_response_api_teste.model.UsuarioPapel;
import br.com.fiap.nexus_response_api_teste.repository.UsuarioRepository;
import br.com.fiap.nexus_response_api_teste.controller.dto.AuthenticationDTO;
import br.com.fiap.nexus_response_api_teste.controller.dto.LoginResponseDTO;
import br.com.fiap.nexus_response_api_teste.controller.dto.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.usuarioRepository.findByEmail(data.email()).isPresent()) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario newUsuario = Usuario.builder()
                .email(data.email())
                .senha(encryptedPassword)
                .papel(UsuarioPapel.USER)
                .nome(data.nome()) // Assuming 'nome' is also part of RegisterDTO
                .cpf(data.cpf()) // Assuming 'cpf' is also part of RegisterDTO
                .build();

        this.usuarioRepository.save(newUsuario);

        return ResponseEntity.ok().build();
    }
}

