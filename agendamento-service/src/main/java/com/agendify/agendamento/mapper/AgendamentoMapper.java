package com.agendify.agendamento.mapper;

import com.agendify.core.mapper.BaseMapper;
import com.agendify.agendamento.dto.AgendamentoInDTO;
import com.agendify.agendamento.dto.AgendamentoOutDTO;
import com.agendify.agendamento.entities.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper extends BaseMapper<Agendamento, AgendamentoInDTO, AgendamentoOutDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "numeroAgd", ignore = true)
    Agendamento toEntity(AgendamentoInDTO dto);
}
