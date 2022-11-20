package com.kolesnyk.service.impl;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.dto.UserDto;
import com.kolesnyk.mapper.impl.UserMapper;
import com.kolesnyk.exception.UserNotFound;
import com.kolesnyk.model.UserEntity;
import com.kolesnyk.repository.UserRepository;
import com.kolesnyk.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public void saveUser(UserCreationDto userDto) {
        userRepository.save(mapper.toEntity(userDto));
    }

    @Override
    public UserDto getById(int id) {
        UserEntity user = userRepository.findById(id)
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
    @Transactional
    public void updateUser(UserCreationDto userDto, int userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFound("there is no user with id " + userId);
        }
        UserEntity user = mapper.toEntity(userDto);
        user.setId(userId);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFound("there is no user with id " + userId);
        }
        userRepository.deleteById(userId);
    }
}
