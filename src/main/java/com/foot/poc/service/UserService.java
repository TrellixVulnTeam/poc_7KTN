package com.foot.poc.service;

import com.foot.poc.model.User;

import java.util.Collection;


public interface UserService {

    Collection<User> findAllUsers();
    User signUp(User user);
}
