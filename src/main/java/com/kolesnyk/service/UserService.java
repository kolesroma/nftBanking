package com.kolesnyk.service;

import com.kolesnyk.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getById(int id);

    Collection<User> getAllUsers();

    void updateUser(User user, int userId);

    void deleteUser(int userId);
}
