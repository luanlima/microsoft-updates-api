package com.microsoft.dto.converter;

import java.util.List;

public interface DtoConverter<T, E> {
    public T toDto(E entity);

    public List<T> entityListToDto(List<E> entityList);

    public E toEntity(T dto);
}