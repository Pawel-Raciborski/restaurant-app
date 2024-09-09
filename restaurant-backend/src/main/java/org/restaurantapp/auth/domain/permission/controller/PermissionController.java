package org.restaurantapp.auth.domain.permission.controller;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.dto.PermissionDto;
import org.restaurantapp.auth.domain.permission.mapper.PermissionMapper;
import org.restaurantapp.auth.domain.permission.service.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("/create")
    public ResponseEntity<PermissionDto> create(@RequestParam("name") String permissionName) {
        PermissionDto createdPermission = PermissionMapper.INSTANCE.mapToDto(permissionService.create(permissionName));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdPermission);
    }

    @GetMapping
    public ResponseEntity<List<PermissionDto>> findAllPaged(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
            ){
        List<PermissionDto> pagedPermissions = permissionService.findAllPaged(page,pageSize).stream()
                .map(PermissionMapper.INSTANCE::mapToDto)
                .toList();

        return ResponseEntity.ok(pagedPermissions);
    }
}
