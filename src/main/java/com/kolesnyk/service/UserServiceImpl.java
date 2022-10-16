package com.kolesnyk.service;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.dto.UserDto;
import com.kolesnyk.dto.UserMapper;
import com.kolesnyk.exception.UserNotFound;
import com.kolesnyk.model.User;
import com.kolesnyk.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
    public UserDto getById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("there is no user with id " + id));
        return mapper.toDto(user);
    }

    @Override
    public Collection<UserDto> getAllUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size))
                .map(mapper::toDto)
                .getContent();
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
