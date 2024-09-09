package org.restaurantapp.auth.domain.permission.repository;

import org.restaurantapp.auth.domain.permission.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    Optional<Permission> findByName(String permissionName);

    @Query("""
    SELECT p FROM Permission p WHERE p.name IN :permissionNames
    """)
    List<Permission> findAllWhereNameIn(@Param("permissionNames") List<String> permissionNames);

    @Query("""
    SELECT p FROM Permission p
    """)
    Page<Permission> findAllPaged(Pageable pageable);
}
