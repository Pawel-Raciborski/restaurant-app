package org.restaurantapp.auth.domain.permission.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.dto.PermissionRoleDto;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionRoleManagementService {
    private final PermissionRoleService permissionRoleService;
    private final RoleService roleService;
    private final PermissionService permissionService;


    public void processPermissionRoleCreation(List<PermissionRoleDto> permissionRoleDtos) {
        permissionRoleDtos.forEach(this::processPermissionRoleCreation);
    }

    private void processPermissionRoleCreation(PermissionRoleDto permissionRoleDto) {
        Role roleToAssignPermissions = roleService.findByName(permissionRoleDto.roleName());
        List<Permission> permissionsToAssign = permissionService.findAllByName(permissionRoleDto.permissionNames());

        permissionsToAssign.forEach(permission -> permissionRoleService.create(roleToAssignPermissions,permission));
    }
}
