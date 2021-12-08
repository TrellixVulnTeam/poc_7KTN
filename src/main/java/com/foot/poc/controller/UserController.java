package com.foot.poc.controller;


import com.foot.poc.model.User;
import com.foot.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    Collection<User> findAllUsers(){
        return this.userService.findAllUsers();
    }

    @PostMapping("/user")
    User signUp(@RequestBody User user){
        return this.userService.signUp(user);
    }


}
