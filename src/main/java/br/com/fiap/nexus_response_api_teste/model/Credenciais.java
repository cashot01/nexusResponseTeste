package br.com.fiap.nexus_response_api_teste.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Credenciais(
        @Email
        @NotBlank
        String email,

        @NotBlank
        String senha
) {}
