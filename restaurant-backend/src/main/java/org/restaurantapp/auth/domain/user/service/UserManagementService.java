package org.restaurantapp.auth.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.service.RoleService;
import org.restaurantapp.auth.domain.user.User;
import org.restaurantapp.auth.domain.user.dto.AddUserRolesDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManagementService {
    private final UserService userService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;


    @Transactional
    public void addRolesToUser(AddUserRolesDto addUserRolesDto) {
        User userToAssignRole = userService.findByEmail(addUserRolesDto.email());
        List<Role> rolesToAssign = roleService.findAllByName(addUserRolesDto.roleNames());

        var roles = rolesToAssign.stream()
                .map(role -> userRoleService.createUserRole(userToAssignRole,role))
                .collect(Collectors.toSet());

        userToAssignRole.getUserRoles().addAll(roles);

        userService.update(userToAssignRole);
    }
}
