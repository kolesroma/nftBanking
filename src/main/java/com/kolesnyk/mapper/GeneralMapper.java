package com.kolesnyk.mapper;

public interface GeneralMapper<Entity, CreationDto, Dto> {
    Entity toEntity(CreationDto creationDto);

    Dto toDto(Entity entity);
}
