package com.kolesnyk.mapper.impl;

import com.kolesnyk.dto.creation.UserCreationDto;
import com.kolesnyk.dto.UserDto;
import com.kolesnyk.mapper.CreationDtoMapper;
import com.kolesnyk.mapper.DtoMapper;
import com.kolesnyk.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DtoMapper<UserEntity, UserDto>, CreationDtoMapper<UserEntity, UserCreationDto> {
    @Override
    public UserEntity toEntity(UserCreationDto userDto) {
        return UserEntity.builder()
                .id(0)
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .balance(userDto.getBalance())
                .enabled(userDto.isEnabled())
                .build();
    }

    @Override
    public UserDto toDto(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .balance(user.getBalance())
                .enabled(user.isEnabled())
                .build();
    }
}
