package com.kolesnyk.dto.mapper;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.dto.UserDto;
import com.kolesnyk.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUser(UserCreationDto userDto) {
        return UserEntity.builder()
                .id(0)
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .balance(userDto.getBalance())
                .enabled(userDto.isEnabled())
                .build();
    }

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
