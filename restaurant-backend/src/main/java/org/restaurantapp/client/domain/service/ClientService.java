package org.restaurantapp.client.domain.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.dto.RegisterUserDataFormDto;
import org.restaurantapp.auth.domain.user.User;
import org.restaurantapp.auth.domain.user.service.UserService;
import org.restaurantapp.client.domain.Client;
import org.restaurantapp.client.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final UserService userService;
    private final ClientRepository clientRepository;
    public Client createClient(RegisterUserDataFormDto registerUserDataFormDto) {
        User registeredUser = userService.create(registerUserDataFormDto);

        Client clientToRegister = Client.builder()
                .user(registeredUser)
                .build();

        return clientRepository.save(clientToRegister);
    }
}
