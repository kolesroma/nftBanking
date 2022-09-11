package com.kolesnyk.controller;

import com.kolesnyk.dto.UserCreationDto;
import com.kolesnyk.dto.UserMapper;
import com.kolesnyk.model.User;
import com.kolesnyk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/nft/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@Valid @RequestBody UserCreationDto userDto, UserMapper mapper) {
        userService.saveUser(mapper.toUser(userDto));
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        return ResponseEntity.of(userService.getById(userId));
    }

    @GetMapping("/page/{page}")
    public Collection<User> getUsersOnPage(@PathVariable int page) {
        return userService.getAllUsers(page);
    }

    @PutMapping("/{userId}")
    public void updateUser(@RequestBody UserCreationDto userDto, UserMapper mapper, @PathVariable int userId) {
        userService.updateUser(mapper.toUser(userDto), userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
