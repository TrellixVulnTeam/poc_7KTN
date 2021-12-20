package com.foot.poc.service;

import com.foot.poc.model.RegistrationRequest;
import com.foot.poc.model.User;
import com.foot.poc.utils.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserService userService;


    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator.test(request.getEmail());
        if (!isValid){
            throw new IllegalStateException("Email not valid");
        }

        return userService.signUp(
                new User(
                        request.getUserName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER,
                        request.getBirthday(),
                        request.getAddress(),
                        request.getPhoneNumber()
                )

        );
    }
}
