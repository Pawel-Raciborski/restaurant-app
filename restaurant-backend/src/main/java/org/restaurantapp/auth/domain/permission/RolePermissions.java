package org.restaurantapp.auth.domain.permission;

import lombok.Builder;

import java.util.List;

@Builder
public record RolePermissions(
        String roleName,
        List<String> permissionNames
) { }
