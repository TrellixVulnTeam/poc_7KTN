package com.foot.poc.service.implementation;


import com.foot.poc.model.User;
import com.foot.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foot.poc.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Collection<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    @Override
    public User signUp(@RequestBody User user){
        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setUserName(user.getUserName());
        newUser.setAddress(user.getAddress());
        newUser.setBirthday(user.getBirthday());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());

        return this.userRepository.save(newUser);
    }

}
