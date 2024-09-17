package org.restaurantapp.worker.dto;

import org.restaurantapp.auth.domain.user.dto.UserDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record WorkerDto(
        String pesel,
        UserDto user,
        BigDecimal hourlyRate,
        LocalDateTime dateOfEmployment
) {
}
