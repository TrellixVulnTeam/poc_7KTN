package com.foot.poc.controller;


import com.foot.poc.model.User;
import com.foot.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("signup")
public class SignUpController {

    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping
    public String signUp(@RequestBody User user) {
        return this.userService.signUp(user);
    }
}
