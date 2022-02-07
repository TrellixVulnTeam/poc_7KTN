package com.foot.poc.controller;


import com.foot.poc.model.User;
import com.foot.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String signUp(@RequestBody User user) {
        return this.userService.signUp(user);
    }
}
