package com.agendify.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInDTO {
    private String nome;
    private String email;
    private String senha;
    private String role;
}
