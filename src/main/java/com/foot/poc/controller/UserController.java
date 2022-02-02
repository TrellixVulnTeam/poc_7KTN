package com.foot.poc.controller;


import com.foot.poc.model.User;
import com.foot.poc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("users")
    Collection<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @PostMapping("users")
    User addUser(@RequestBody User newUser) {
        return this.userService.addUser(newUser);
    }

    @DeleteMapping("users/{id}")
    void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }

    @GetMapping("login")
    Long login(@RequestParam String email, @RequestParam String password) {
        return this.userService.login(email, password);
    }
}
