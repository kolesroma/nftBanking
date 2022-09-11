package com.kolesnyk.service;

import com.kolesnyk.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    Optional<User> getById(int id);

    Collection<User> getAllUsers(int page);

    void updateUser(User user, int userId);

    void deleteUser(int userId);
}
