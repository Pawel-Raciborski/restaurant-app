package org.restaurantapp.auth.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.dto.RegisterUserDataFormDto;
import org.restaurantapp.auth.domain.user.User;
import org.restaurantapp.auth.domain.role.repository.UserRepository;
import org.restaurantapp.auth.domain.user.exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User create(RegisterUserDataFormDto registerUserDataFormDto) {
        Optional<User> existingUserOpt = userRepository.findByEmail(registerUserDataFormDto.email());

        if(existingUserOpt.isPresent()){
            throw new UserExistsException("User with email [%s] already exists".formatted(registerUserDataFormDto.email()), HttpStatus.CONFLICT);
        }
        User userToRegister = buildUserData(registerUserDataFormDto);

        return userRepository.save(userToRegister);
    }

    private User buildUserData(RegisterUserDataFormDto registerUserDataFormDto) {
        return User.builder()
                .firstName(registerUserDataFormDto.firstName())
                .surname(registerUserDataFormDto.surname())
                .email(registerUserDataFormDto.email())
                .password(passwordEncoder.encode(registerUserDataFormDto.password()))
                .build();
    }
}
