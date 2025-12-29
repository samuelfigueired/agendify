package com.agendify.user.controller;

import com.agendify.core.config.security.service.JwtService;
import com.agendify.user.dto.LoginDTO;
import com.agendify.user.dto.TokenDTO;
import com.agendify.user.dto.UserInDTO;
import com.agendify.user.dto.UserOutDTO;
import com.agendify.user.entities.User;
import com.agendify.user.mapper.UserMapper;
import com.agendify.user.repositories.UserRepository;
import com.agendify.user.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO dto) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha())
        );

        User user = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));

        String token = jwtService.gerarToken(user.getEmail());

        return ResponseEntity.ok(new TokenDTO(token));
    }


    @PostMapping("/register")
    public ResponseEntity<UserOutDTO> register(@RequestBody UserInDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já registrado.");
        }

        UserOutDTO saved = userService.criar(dto);

        return ResponseEntity.ok(saved);
    }
}
