package org.restaurantapp.auth.domain.permission.service;

import lombok.RequiredArgsConstructor;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.exception.PermissionAlreadyExistException;
import org.restaurantapp.auth.domain.permission.exception.PermissionNotFoundException;
import org.restaurantapp.auth.domain.permission.repository.PermissionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionRoleService permissionRoleService;

    @Transactional
    public Permission create(String permissionName) {
        Optional<Permission> optPermission = permissionRepository.findByName(permissionName);

        if(optPermission.isPresent()){
            throw new PermissionAlreadyExistException("Permission with name: [%s] already exists!".formatted(permissionName), HttpStatus.CONFLICT);
        }

        Permission permissionToCreate = Permission.builder()
                .name(permissionName)
                .build();

        return permissionRepository.save(permissionToCreate);
    }

    public Permission findByName(String permissionName) {
        return permissionRepository.findByName(permissionName).orElseThrow(
                () -> new PermissionNotFoundException("Permission with name: [%s] not found".formatted(permissionName),HttpStatus.NOT_FOUND));
    }

    public List<Permission> findAllByName(List<String> permissionNames) {
        return permissionRepository.findAllWhereNameIn(permissionNames);
    }

    public List<Permission> findAllPaged(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);

        return permissionRepository.findAllPaged(pageable).getContent();
    }

    @Transactional
    public void delete(String permissionName) {
        Permission permissionToRemove = findByName(permissionName);

        permissionRoleService.removePermissionFromRoles(permissionToRemove);
        permissionRepository.delete(permissionToRemove);
    }
}
