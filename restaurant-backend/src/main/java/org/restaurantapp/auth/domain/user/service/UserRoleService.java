package org.restaurantapp.auth.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.exception.UserRoleAlreadyExistsException;
import org.restaurantapp.auth.domain.user.User;
import org.restaurantapp.auth.domain.user.UserRole;
import org.restaurantapp.auth.domain.user.repository.UserRoleRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Transactional
    public UserRole createUserRole(User user, Role roleToAssign) {
        UserRole userRoleToAdd = buildUserRole(user,roleToAssign);
        Example<UserRole> example = Example.of(userRoleToAdd);

        if(userRoleRepository.findOne(example).isPresent()){
            throw new UserRoleAlreadyExistsException("User [%s] has already assigned role [%s]".formatted(user.getEmail(),roleToAssign.getName()), HttpStatus.CONFLICT);
        }

        return userRoleRepository.save(userRoleToAdd);
    }

    private UserRole buildUserRole(User user, Role role) {
        return UserRole.builder()
                .user(user)
                .role(role)
                .build();
    }
}
