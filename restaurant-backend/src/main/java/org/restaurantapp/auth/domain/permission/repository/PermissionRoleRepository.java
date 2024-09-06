package org.restaurantapp.auth.domain.permission.repository;

import org.restaurantapp.auth.domain.permission.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRoleRepository extends JpaRepository<PermissionRole,Integer> {
}
