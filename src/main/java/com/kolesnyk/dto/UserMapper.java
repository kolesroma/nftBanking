package com.kolesnyk.dto;

import com.kolesnyk.model.User;

public class UserMapper {
    public User toUser(UserCreationDto userDto) {
        return User.builder()
                .id(0)
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .balance(userDto.getBalance())
                .enabled(userDto.isEnabled())
                .build();
    }

    public UserCreationDto toDto(User user) {
        return UserCreationDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .balance(user.getBalance())
                .enabled(user.isEnabled())
                .build();
    }
}
