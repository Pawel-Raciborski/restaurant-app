package org.restaurantapp.auth.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.user.dto.AddUserRolesDto;
import org.restaurantapp.auth.domain.user.service.UserManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserManagementService userManagementService;
    @PutMapping("/role")
    public ResponseEntity<Void> addRole(@RequestBody AddUserRolesDto addUserRolesDto){
        userManagementService.addRolesToUser(addUserRolesDto);

        return ResponseEntity.ok().build();
    }
}
