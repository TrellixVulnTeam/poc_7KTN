package com.foot.poc.controller;


import com.foot.poc.model.User;
import com.foot.poc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/users")
    Collection<User> findAllUsers() {
        return this.userService.findAllUsers();
    }
}
