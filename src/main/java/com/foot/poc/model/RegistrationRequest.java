package com.foot.poc.model;

import com.foot.poc.utils.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private final String userName;
    private final String email;
    private final String password;
    private final UserRole userRole;
    private final LocalDate birthday;
    private final String address;
    private final String phoneNumber;
}
