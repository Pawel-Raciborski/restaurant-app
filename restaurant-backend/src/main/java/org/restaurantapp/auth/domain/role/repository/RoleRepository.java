package org.restaurantapp.auth.domain.role.repository;

import org.restaurantapp.auth.domain.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String name);
    @Query("""
    SELECT r FROM Role r WHERE r.name IN :roleNames
    """)
    List<Role> findAllByNames(@Param("roleNames") List<String> roleNames);
}
