package org.restaurantapp.auth.domain.user.repository;

import org.restaurantapp.auth.domain.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
