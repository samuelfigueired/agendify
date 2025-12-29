package com.agendify.user.mapper;

import com.agendify.core.mapper.BaseMapper;
import com.agendify.user.dto.UserInDTO;
import com.agendify.user.dto.UserOutDTO;
import com.agendify.user.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserInDTO, UserOutDTO> {
}
