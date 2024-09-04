package org.restaurantapp.auth.domain.role.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @PostMapping("/create")
    public ResponseEntity<Void> create(String name){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
