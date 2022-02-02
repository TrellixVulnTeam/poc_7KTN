package com.foot.poc.controller;


import com.foot.poc.model.User;
import com.foot.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    Collection<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping("users/{id}")
    User findUser(@PathVariable Long id) {
        return this.userService.findUser(id);
    }

    @DeleteMapping("users/{id}")
    String deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return "User deleted !";
    }

    @PutMapping("users/{id}")
    User editUser(@PathVariable Long id, @RequestBody User user) {
        return this.userService.editUser(id, user);
    }

}
