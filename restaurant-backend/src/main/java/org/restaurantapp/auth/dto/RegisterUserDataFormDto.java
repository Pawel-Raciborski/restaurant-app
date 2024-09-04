package org.restaurantapp.auth.dto;

public record RegisterUserDataFormDto(
        String firstName,
        String surname,
        String email,
        String password
) {
}
