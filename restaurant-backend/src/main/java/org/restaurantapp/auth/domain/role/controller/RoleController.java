package org.restaurantapp.auth.domain.role.controller;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.dto.RoleDto;
import org.restaurantapp.auth.domain.role.mapper.RoleMapper;
import org.restaurantapp.auth.domain.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleDto> create(@RequestParam(name = "roleName") String roleName) {
        RoleDto createdRole = RoleMapper.INSTANCE.mapFromEntity(roleService.create(roleName));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdRole);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getPagedRoles(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ){
        var roles = roleService.findPaged(page,pageSize).stream()
                .map(RoleMapper.INSTANCE::mapFromEntity)
                .toList();

        return ResponseEntity.ok(roles);
    }
}
