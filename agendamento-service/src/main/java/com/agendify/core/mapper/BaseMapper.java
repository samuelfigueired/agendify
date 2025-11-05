package com.agendify.core.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

public interface BaseMapper<E, In, Out> {

    E toEntity(In dto);
    Out toOutDTO(E entity);

    default List<Out> toOutDTOList(List<E> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                .filter(Objects::nonNull)
                .map(this::toOutDTO)
                .collect(Collectors.toList());
    }

    default List<E> toEntityList(List<In> dtos) {
        if (dtos == null) return List.of();
        return dtos.stream()
                .filter(Objects::nonNull)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
