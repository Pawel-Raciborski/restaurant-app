package org.restaurantapp.auth.domain.permission.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.RolePermission;
import org.restaurantapp.auth.domain.permission.RolePermissions;
import org.restaurantapp.auth.domain.permission.dto.RolePermissionsDto;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.exception.RoleNotFoundException;
import org.restaurantapp.auth.domain.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolePermissionsManagementService {
    private final RolePermissionService rolePermissionService;
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Transactional
    public RolePermissions assignPermissionsToRole(RolePermissionsDto rolePermissionsDto){
        List<RolePermission> rolePermissions = processPermissionRoleCreation(rolePermissionsDto);

        return createRolePermissionsDto(rolePermissions);
    }

    @Transactional
    public List<RolePermission> processPermissionRoleCreation(RolePermissionsDto rolePermissionsDto) {
        Role roleToAssignPermissions = roleService.findByName(rolePermissionsDto.roleName());
        List<Permission> permissionsToAssign = permissionService.findAllByName(rolePermissionsDto.permissionNames());

        return permissionsToAssign.stream().map(permission -> rolePermissionService.create(roleToAssignPermissions,permission)).toList();
    }

    private RolePermissions createRolePermissionsDto(List<RolePermission> rolePermissions){
        Optional<String> roleNameOpt = rolePermissions.stream().map(p -> p.getRole().getName()).findFirst();

        if (roleNameOpt.isEmpty()) {
            throw new RoleNotFoundException("Role not found", HttpStatus.NOT_FOUND);
        }

        String roleName = roleNameOpt.get();
        List<String> addedPermissionsList = rolePermissions.stream()
                .map(permissionRole -> permissionRole.getPermission().getName())
                .toList();

        return RolePermissions.builder()
                .roleName(roleName)
                .permissionNames(addedPermissionsList)
                .build();
    }
}
