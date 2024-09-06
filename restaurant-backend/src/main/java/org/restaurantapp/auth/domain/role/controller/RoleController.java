package org.restaurantapp.auth.domain.role.controller;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestParam(name = "roleName") String roleName) {
        Role createdRole = roleService.create(roleName);

        return ResponseEntity
                .created(URI.create("/api/v1/roles/create/" + createdRole.getId()))
                .build();
    }
}
