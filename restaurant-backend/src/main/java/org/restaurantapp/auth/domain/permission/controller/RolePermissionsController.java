package org.restaurantapp.auth.domain.permission.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.RolePermissions;
import org.restaurantapp.auth.domain.permission.dto.PermissionDto;
import org.restaurantapp.auth.domain.permission.dto.RolePermissionsDto;
import org.restaurantapp.auth.domain.permission.mapper.PermissionMapper;
import org.restaurantapp.auth.domain.permission.service.PermissionService;
import org.restaurantapp.auth.domain.permission.service.RolePermissionService;
import org.restaurantapp.auth.domain.permission.service.RolePermissionsManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/role/permissions")
@RequiredArgsConstructor
public class RolePermissionsController {
    private final RolePermissionsManagementService rolePermissionsManagementService;
    private final RolePermissionService rolePermissionService;

    @PostMapping
    public ResponseEntity<RolePermissions> create(@RequestBody RolePermissionsDto rolePermissionsDto) {
        var newRolePermissionsList = rolePermissionsManagementService.assignPermissionsToRole(rolePermissionsDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newRolePermissionsList);
    }

    @GetMapping
    public ResponseEntity<List<String>> getRolePermissions(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "roleName") String roleName
    ) {
        var permissions = rolePermissionService.findPermissionsForRole(roleName, page, pageSize).stream()
                .map(Permission::getName)
                .toList();

        return ResponseEntity.ok(permissions);
    }

    @DeleteMapping
    public ResponseEntity<Void> removePermissionFromRole(
            @RequestParam("permissionName") String permissionName,
            @RequestParam("roleName") String roleName
    ){
        rolePermissionsManagementService.removePermissionFromRole(permissionName,roleName);

        return ResponseEntity.ok().build();
    }
}
