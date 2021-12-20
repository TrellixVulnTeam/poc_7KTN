package com.foot.poc.service;

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
    private final UserService userService;

    @Autowired
    private final ConfirmationTokenService confirmTokenService;


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

    public String confirmToken(String token) {

        ConfirmationToken confirmationToken = confirmTokenService.getToken(token);

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email already confirmed");
        }

        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token expired");
        }

        confirmTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());

        return "Confirmed";

    }
}
