package com.agendify.user.service;

import com.agendify.user.dto.UserInDTO;
import com.agendify.user.dto.UserOutDTO;

import java.util.List;

public interface UserService {

    UserOutDTO criar(UserInDTO dto);

    List<UserOutDTO> listar();

    UserOutDTO buscarPorId(Long id);

    UserOutDTO atualizar(Long id, UserInDTO dto);

    void deletar(Long id);
}
