package org.restaurantapp.worker.dto;

import org.restaurantapp.auth.dto.RegisterUserDataFormDto;

import java.math.BigDecimal;

public record WorkerDataFormDto(
        String pesel,
        RegisterUserDataFormDto registerUserData,
        BigDecimal hourlyRate,
        String role
) {
}
