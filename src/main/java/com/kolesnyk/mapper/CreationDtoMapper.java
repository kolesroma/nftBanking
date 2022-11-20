package com.kolesnyk.mapper;

public interface CreationDtoMapper<Entity, CreationDto> {
    Entity toEntity(CreationDto creationDto);
}
