package br.com.fiap.nexus_response_api_teste.controller.dto;

import br.com.fiap.nexus_response_api_teste.model.UsuarioPapel;

public record RegisterDTO(String email, String senha, String nome, String cpf, UsuarioPapel papel) {
}

