package com.kolesnyk.service;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.dto.UserDto;
import com.kolesnyk.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    void saveUser(UserCreationDto userDto);

    UserDto getById(int id);

    Collection<UserDto> getAllUsers(int page, int size);

    void updateUser(UserCreationDto userDto, int userId);

    void deleteUser(int userId);
}
