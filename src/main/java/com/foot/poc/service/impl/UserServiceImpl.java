package com.foot.poc.service.impl;

import com.foot.poc.model.ConfirmationToken;
import com.foot.poc.model.User;
import com.foot.poc.repository.UserRepository;
import com.foot.poc.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with email %s not found";

    // <----                              Security
    @Autowired
    private final PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUp(User user) {
        boolean userExits = this.userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExits) {
            throw new IllegalStateException("Email already used !");
        }
        String encodedPassword = bCryptPasswordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        this.userRepository.save(user);

        //TODO: Confirmation token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //TODO: Send email

        return token;
    }

    public int enableUser(String email) {
        return this.userRepository.enableUser(email);
    }
    //                                                                                      ---->


    public Collection<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUser(Long id) {
        User user = this.userRepository.getById(id);
        this.userRepository.delete(user);
    }

    public User addUser(User user) {
        User newUser = new User();
        String email = user.getEmail();
        String address = user.getAddress();
        String name = user.getUsername();
        String password = user.getPassword();

        newUser.setPassword(password);
        newUser.setAddress(address);
        newUser.setUserName(name);
        newUser.setEmail(email);

        this.userRepository.save(newUser);
        return user;
    }

    public Long login(String email, String password) {
        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
        String encodedPassword = this.bCryptPasswordEncoder.bCryptPasswordEncoder().encode(password);
        if (user.getEmail().equals(email) && user.getPassword().equals(encodedPassword)) {
            return user.getId();
        } else {
            throw new IllegalStateException("User already exists");
        }
    }

}
