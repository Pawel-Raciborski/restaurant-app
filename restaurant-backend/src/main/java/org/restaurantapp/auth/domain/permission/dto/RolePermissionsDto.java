package org.restaurantapp.auth.domain.permission.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RolePermissionsDto(
        String roleName,
        List<String> permissionNames
) {
}
