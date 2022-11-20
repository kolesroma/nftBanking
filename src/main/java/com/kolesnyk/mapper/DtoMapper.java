package com.kolesnyk.mapper;

public interface DtoMapper<Entity, Dto> {
    Dto toDto(Entity entity);
}
