package com.foot.poc.service;

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
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with email %s not found";

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUp(User user){
        boolean userExits = userRepository.findByEmail(user.getEmail()).isPresent();

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

    public int enableUser(String email){
        return userRepository.enableUser(email);
    }

}
