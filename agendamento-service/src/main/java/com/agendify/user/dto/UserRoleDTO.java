package com.agendify.user.dto;

import com.agendify.user.entities.enums.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDTO {

    @NotNull
    private UserRole role;
}
