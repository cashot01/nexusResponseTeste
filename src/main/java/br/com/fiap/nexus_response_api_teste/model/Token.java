package br.com.fiap.nexus_response_api_teste.model;

public record Token(
        String token,
        Long expiration,
        String type,
        String papel
) {

}
