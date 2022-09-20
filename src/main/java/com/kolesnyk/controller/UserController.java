package com.kolesnyk.controller;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.exception.EntityNotFound;
import com.kolesnyk.model.User;
import com.kolesnyk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@RequestMapping("/nft/users")
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@Valid @RequestBody UserCreationDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        return ResponseEntity.of(userService.getById(userId));
    }

    @GetMapping
    public Collection<User> getUsersOnPage(@RequestParam @Min(0) int page, @RequestParam @Min(1) @Max(100) int size) {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFound.class, ConstraintViolationException.class})
    public String entityValidation(RuntimeException e) {
        return e.getMessage();
    }
}
