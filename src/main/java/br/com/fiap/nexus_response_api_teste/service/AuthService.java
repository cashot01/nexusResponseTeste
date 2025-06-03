package br.com.fiap.nexus_response_api_teste.service;

import br.com.fiap.nexus_response_api_teste.model.Credenciais;
import br.com.fiap.nexus_response_api_teste.model.Token;

import br.com.fiap.nexus_response_api_teste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(username, null));
        System.out.println("Usuario encotrado:" + user);
        return user;
    }

    public Token login(Credenciais credenciais){
        var usuario = repository.findByEmail(credenciais.email())
                .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado", null));

        if(!passwordEncoder.matches(credenciais.senha(), usuario.getSenha()) ){
            throw new BadCredentialsException("Senha incorreta");
        }

        return tokenService.createToken(usuario);
    }



}
