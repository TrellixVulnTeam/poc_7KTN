package com.foot.poc.controller;


import com.foot.poc.model.User;
import com.foot.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    Collection<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping("{id}")
    User findUser(@PathVariable Long id) {
        return this.userService.findUser(id);
    }

    @DeleteMapping("{id}")
    boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping("{id}")
    User editUser(@PathVariable Long id, @RequestBody User user) {
        return this.userService.editUser(id, user);
    }

}
