package com.kolesnyk.service;

import com.kolesnyk.model.User;
import com.kolesnyk.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Collection<User> getAllUsers(int page) {
        int pageSize = 5;
        Pageable paging = PageRequest.of(page, pageSize);
        Page<User> pagedUsers = userRepository.findAll(paging);
        return  pagedUsers.hasContent() ?
                pagedUsers.getContent() :
                new ArrayList<>();
    }

    @Override
    @Transactional
    public void updateUser(User user, int userId) {
        User dbUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("there is no user with id " + userId));
        dbUser.setBalance(user.getBalance());
        dbUser.setUsername(user.getUsername());
        dbUser.setEmail(user.getEmail());
        dbUser.setEnabled(user.isEnabled());
        dbUser.setPhone(user.getPhone());
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
