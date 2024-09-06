package org.restaurantapp.auth.domain.user.dto;

import java.util.List;

public record AddUserRolesDto(
        String email,
        List<String> roleNames
) {
}
