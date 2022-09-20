package com.kolesnyk.service;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    void saveUser(UserCreationDto userDto);

    Optional<User> getById(int id);

    Collection<User> getAllUsers(int page, int size);

    void updateUser(UserCreationDto userDto, int userId);

    void deleteUser(int userId);
}
