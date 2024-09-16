package org.restaurantapp.auth.domain.permission.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.RolePermission;
import org.restaurantapp.auth.domain.permission.exception.PermissionRoleAlreadyExistException;
import org.restaurantapp.auth.domain.permission.repository.RolePermissionRepository;
import org.restaurantapp.auth.domain.role.Role;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RolePermissionService {
    private final RolePermissionRepository rolePermissionRepository;

    @Transactional
    public RolePermission create(Role role, Permission permission) {
        RolePermission rolePermissionToCreate = RolePermission.builder().role(role).permission(permission).build();
        Example<RolePermission> permissionRoleExample = Example.of(rolePermissionToCreate);

        if(rolePermissionRepository.findOne(permissionRoleExample).isPresent()){
            throw new PermissionRoleAlreadyExistException("Permission [%s] for role: [%s] was already assigned".formatted(permission.getName(),role.getName()), HttpStatus.CONFLICT);
        }

        return rolePermissionRepository.save(rolePermissionToCreate);
    }

    public void removePermissionFromRoles(Permission permissionToRemove) {
        rolePermissionRepository.deleteAllWherePermission(permissionToRemove.getId());
    }
}
