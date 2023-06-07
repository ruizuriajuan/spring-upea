package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.entity.ConfirmationToken;
import com.ruizuria.ecommerce.repository.ConfirmationTokenRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConfirmationTokenService {
    @Autowired
    ConfirmationTokenRepository repository;

    public ConfirmationToken create(ConfirmationToken input) {
        return repository.save(input);
    }

    public ConfirmationToken getByToken(String token) {
        return repository.findByToken(token)
                .orElseThrow(() -> new EntityNotFoundException("Confirmation token not found"));
    }

    public void setConfirmeAt(ConfirmationToken confirmationToken){
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        repository.save(confirmationToken);
    }

}
