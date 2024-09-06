package org.restaurantapp.auth.domain.permission.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.restaurantapp.auth.domain.permission.dto.PermissionRoleDto;
import org.restaurantapp.auth.domain.permission.service.PermissionRoleManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/roles/permissions")
@RequiredArgsConstructor
public class PermissionRoleController {
    private final PermissionRoleManagementService permissionRoleManagementService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody List<PermissionRoleDto> permissionRoleDtos) {
        permissionRoleManagementService.processPermissionRoleCreation(permissionRoleDtos);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
