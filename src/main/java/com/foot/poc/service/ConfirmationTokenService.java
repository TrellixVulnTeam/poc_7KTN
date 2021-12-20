package com.foot.poc.service;


import com.foot.poc.model.ConfirmationToken;
import com.foot.poc.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
    public ConfirmationToken getToken(String token){
        return confirmationTokenRepository.findByToken(token).orElseThrow(()->
            new IllegalStateException("Token not found"));
    }

    public int setConfirmedAt(String token){
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
