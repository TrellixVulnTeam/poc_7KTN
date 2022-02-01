package com.foot.poc.service.impl;

import com.foot.poc.model.ConfirmationToken;
import com.foot.poc.model.RegistrationRequest;
import com.foot.poc.model.User;
import com.foot.poc.utils.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class RegistrationService {

    @Autowired
    private final EmailValidator emailValidator;

    @Autowired
    private final UserServiceImpl userServiceImpl;

    @Autowired
    private final ConfirmationTokenService confirmTokenService;


    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator.test(request.getEmail());
        if (!isValid){
            throw new IllegalStateException("Email not valid");
        }

        return userServiceImpl.signUp(
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

    public String confirmToken(String token) {

        ConfirmationToken confirmationToken = confirmTokenService.getToken(token);

        if (confirmationToken.getUser().isAccountNonLocked() == false) {
            throw new IllegalStateException("Account locked, Please confirm your account before signing in");
        }

        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token expired");
        }

        confirmTokenService.setConfirmedAt(token);
        userServiceImpl.enableUser(confirmationToken.getUser().getEmail());

        return "Confirmed";

    }
}
