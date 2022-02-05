package com.foot.poc.service.impl;

import com.foot.poc.model.User;
import com.foot.poc.repository.UserRepository;
import com.foot.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public String signUp(User user) {
        boolean userExits = this.userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExits) {
            throw new IllegalStateException("Email already used !");
        }
        user.setJoined(LocalDate.now());
        this.userRepository.save(user);
        return "User created successfully";
    }

    @Override
    public Collection<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User findUser(Long id) {
        return this.userRepository.getById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Long login(String email, String password) {
        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("Could not find user with email" + email));

        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return user.getId();
        } else {
            throw new IllegalStateException("Bad credentials");
        }
    }

    @Override
    public User editUser(Long id, User newUserInfo) {
        User oldInfoUSer = this.userRepository.getById(id);
        oldInfoUSer = newUserInfo;
        this.userRepository.save(oldInfoUSer);
        return oldInfoUSer;
    }

}
