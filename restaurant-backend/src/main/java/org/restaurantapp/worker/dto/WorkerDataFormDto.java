package org.restaurantapp.worker.dto;

import org.restaurantapp.auth.dto.RegisterUserDataFormDto;

import java.math.BigDecimal;
import java.util.List;

public record WorkerDataFormDto(
        String pesel,
        RegisterUserDataFormDto registerUserData,
        BigDecimal hourlyRate,
        List<String> roles
) {
}
