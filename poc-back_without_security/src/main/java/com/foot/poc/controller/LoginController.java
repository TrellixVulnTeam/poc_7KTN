package com.foot.poc.controller;

import com.foot.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;
    @CrossOrigin
    @GetMapping
    Long login(@RequestParam String email, @RequestParam String password) {
        return this.userService.login(email, password);
    }
}
