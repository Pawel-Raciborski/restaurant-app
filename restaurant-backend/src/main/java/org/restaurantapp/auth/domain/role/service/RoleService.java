package org.restaurantapp.auth.domain.role.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.exception.RoleExistsException;
import org.restaurantapp.auth.domain.role.exception.RoleNotFoundException;
import org.restaurantapp.auth.domain.role.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RoleNotFoundException("Role with name [%s] not found".formatted(roleName), HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Role create(String roleName) {
        Optional<Role> existingRoleOpt = roleRepository.findByName(roleName);

        if(existingRoleOpt.isPresent()){
            throw new RoleExistsException("Role with name [%s] already exist!".formatted(roleName),HttpStatus.CONFLICT);
        }

        Role roleToCreate = Role.builder()
                .name(roleName)
                .build();

        return roleRepository.save(roleToCreate);
    }
}
