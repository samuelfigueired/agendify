package com.agendify.user.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Usuário não encontrado com o ID: " + id);
    }

    public UserNotFoundException(String email) {
        super("Usuário não encontrado com o e-mail: " + email);
    }
}