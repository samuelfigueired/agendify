package com.agendify.user.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOutDTO {
    private Long id;
    private String nome;
    private String email;
    private String role;
    private boolean ativo;
}
