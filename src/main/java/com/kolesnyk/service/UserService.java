package com.kolesnyk.service;

import com.kolesnyk.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    User saveUser();

    Optional<User> getById(int id);

    Collection<User> getAllUsers();


}
