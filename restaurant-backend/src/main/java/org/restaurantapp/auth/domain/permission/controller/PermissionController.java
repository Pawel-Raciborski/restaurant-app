package org.restaurantapp.auth.domain.permission.controller;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.service.PermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestParam("name") String permissionName) {
        Permission createdPermission = permissionService.create(permissionName);

        return ResponseEntity.created(URI.create("/permissions/create/%s".formatted(createdPermission.getId())))
                .build();
    }
}
