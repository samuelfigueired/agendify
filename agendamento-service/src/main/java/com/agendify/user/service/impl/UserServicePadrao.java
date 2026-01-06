package com.agendify.user.service.impl;

import com.agendify.user.dto.UserInDTO;
import com.agendify.user.dto.UserOutDTO;
import com.agendify.user.entities.User;
import com.agendify.user.entities.enums.UserRole;
import com.agendify.user.exceptions.UserNotFoundException;
import com.agendify.user.mapper.UserMapper;
import com.agendify.user.repositories.UserRepository;
import com.agendify.user.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServicePadrao implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    public UserOutDTO criar(UserInDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        User user = mapper.toEntity(dto);

        user.setSenha(encoder.encode(dto.getSenha()));
        user.setRole(UserRole.USER);
        user.setAtivo(true);

        return mapper.toOutDTO(repository.save(user));
    }

    @Override
    public List<UserOutDTO> listar() {
        return mapper.toOutDTOList(repository.findAll());
    }

    @Override
    public UserOutDTO buscarPorId(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return mapper.toOutDTO(user);
    }

    @Override
    public UserOutDTO atualizar(Long id, UserInDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (dto.getNome() != null && !dto.getNome().isBlank()) {
            user.setNome(dto.getNome());
        }

        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            user.setEmail(dto.getEmail());
        }

        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
            user.setSenha(encoder.encode(dto.getSenha()));
        }

        return mapper.toOutDTO(repository.save(user));
    }

    @Override
    public void deletar(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        repository.delete(user);
    }

    @Override
    public UserOutDTO atualizarRole(Long id, UserRole role) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setRole(role);

        return mapper.toOutDTO(repository.save(user));
    }

}
