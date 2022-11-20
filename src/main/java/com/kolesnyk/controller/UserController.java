package com.kolesnyk.controller;

import com.kolesnyk.dto.creation.UserCreationDto;
import com.kolesnyk.dto.UserDto;
import com.kolesnyk.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@RequestMapping("/nft/users")
@Validated
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@Valid @RequestBody UserCreationDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable int userId) {
        return userService.getById(userId);
    }

    @GetMapping
    public Collection<UserDto> getUsersOnPage(@RequestParam @Min(0) int page, @RequestParam @Min(1) @Max(100) int size) {
        return userService.getAllUsers(page, size);
    }

    @PutMapping("/{userId}")
    public void updateUser(@Valid @RequestBody UserCreationDto userDto, @PathVariable int userId) {
        userService.updateUser(userDto, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
