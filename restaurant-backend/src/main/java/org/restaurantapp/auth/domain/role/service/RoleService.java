package org.restaurantapp.auth.domain.role.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.exception.RoleNotFoundException;
import org.restaurantapp.auth.domain.role.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RoleNotFoundException("Role with name [%s] not found".formatted(roleName), HttpStatus.NOT_FOUND));
    }
}
