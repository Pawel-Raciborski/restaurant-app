package org.restaurantapp.auth.domain.permission.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.PermissionRole;
import org.restaurantapp.auth.domain.permission.exception.PermissionRoleAlreadyExistException;
import org.restaurantapp.auth.domain.permission.repository.PermissionRoleRepository;
import org.restaurantapp.auth.domain.role.Role;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PermissionRoleService {
    private final PermissionRoleRepository permissionRoleRepository;

    @Transactional
    public PermissionRole create(Role role, Permission permission) {
        PermissionRole permissionRoleToCreate = PermissionRole.builder().role(role).permission(permission).build();
        Example<PermissionRole> permissionRoleExample = Example.of(permissionRoleToCreate);

        if(permissionRoleRepository.findOne(permissionRoleExample).isPresent()){
            throw new PermissionRoleAlreadyExistException("Permission [%s] for role: [%s] was already assigned".formatted(permission.getName(),role.getName()), HttpStatus.CONFLICT);
        }

        return permissionRoleRepository.save(permissionRoleToCreate);
    }

    public void removePermissionFromRoles(Permission permissionToRemove) {
        permissionRoleRepository.deleteAllWherePermission(permissionToRemove.getId());
    }
}
