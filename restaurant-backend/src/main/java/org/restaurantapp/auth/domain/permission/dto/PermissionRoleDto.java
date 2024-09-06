package org.restaurantapp.auth.domain.permission.dto;

import java.util.List;

public record PermissionRoleDto(
        String roleName,
        List<String> permissionNames
) {
}
