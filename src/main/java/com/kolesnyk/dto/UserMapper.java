package com.kolesnyk.dto;

import com.kolesnyk.model.User;
import org.springframework.stereotype.Component;

@Component
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

    public UserDto toDto(User user) {
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
