package com.kolesnyk.controller;

import com.kolesnyk.model.User;
import com.kolesnyk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUserById(@RequestParam int id) {
        return userService.getById(id).orElseThrow();
    }
}
