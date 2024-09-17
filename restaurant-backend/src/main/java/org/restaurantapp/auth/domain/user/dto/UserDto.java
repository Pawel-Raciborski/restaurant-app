package org.restaurantapp.auth.domain.user.dto;

public record UserDto(
        String firstName,
        String surname,
        String email
) {
}
