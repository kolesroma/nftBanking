package com.kolesnyk.service;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.dto.UserMapper;
import com.kolesnyk.exception.UserNotFound;
import com.kolesnyk.model.User;
import com.kolesnyk.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveUser(UserCreationDto userDto) {
        userRepository.save(mapper.toUser(userDto));
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Collection<User> getAllUsers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<User> pagedUsers = userRepository.findAll(paging);
        return  pagedUsers.hasContent() ?
                pagedUsers.getContent() :
                new ArrayList<>();
    }

    @Override
    public void updateUser(UserCreationDto userDto, int userId) {
        if (!userRepository.existsById(userId))
            throw new UserNotFound("there is no user with id " + userId);
        User user = mapper.toUser(userDto);
        user.setId(userId);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        if (!userRepository.existsById(userId))
            throw new UserNotFound("there is no user with id " + userId);
        userRepository.deleteById(userId);
    }
}
