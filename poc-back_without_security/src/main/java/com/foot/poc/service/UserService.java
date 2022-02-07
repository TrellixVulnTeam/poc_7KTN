package com.foot.poc.service;

import com.foot.poc.model.User;

import java.util.Collection;

public interface UserService {

    Collection<User> findAllUsers();

    User findUser(Long id);

    boolean deleteUser(Long id);

    String signUp(User user);

    Long login(String email, String password);

    User editUser(Long id, User user);

}
