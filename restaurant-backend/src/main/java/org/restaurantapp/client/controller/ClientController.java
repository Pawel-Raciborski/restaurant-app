package org.restaurantapp.client.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.restaurantapp.auth.dto.RegisterUserDataFormDto;
import org.restaurantapp.client.domain.Client;
import org.restaurantapp.client.domain.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterUserDataFormDto registerUserData){
        Client registeredClient = clientService.createClient(registerUserData);
        log.info("Client registered: [{}]",registeredClient);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
