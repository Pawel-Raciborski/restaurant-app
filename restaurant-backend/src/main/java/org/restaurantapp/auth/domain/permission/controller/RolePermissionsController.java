package org.restaurantapp.auth.domain.permission.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.restaurantapp.auth.domain.permission.RolePermissions;
import org.restaurantapp.auth.domain.permission.dto.PermissionDto;
import org.restaurantapp.auth.domain.permission.dto.RolePermissionsDto;
import org.restaurantapp.auth.domain.permission.mapper.PermissionMapper;
import org.restaurantapp.auth.domain.permission.service.PermissionService;
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
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<RolePermissions> create(@RequestBody RolePermissionsDto rolePermissionsDto) {
        var newRolePermissionsList= rolePermissionsManagementService.assignPermissionsToRole(rolePermissionsDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newRolePermissionsList);
    }

    @GetMapping
    public ResponseEntity<List<PermissionDto>> getRolePermissions(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "pageSize") Integer pageSize
    ){
        var permissions = permissionService.findAllPaged(page,pageSize).stream()
                .map(PermissionMapper.INSTANCE::mapToDto)
                .toList();

        return ResponseEntity.ok(permissions);
    }

}
