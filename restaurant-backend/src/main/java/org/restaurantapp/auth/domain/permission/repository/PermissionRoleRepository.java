package org.restaurantapp.auth.domain.permission.repository;

import org.restaurantapp.auth.domain.permission.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PermissionRoleRepository extends JpaRepository<PermissionRole,Integer> {
    @Modifying
    @Query("""
    DELETE PermissionRole pr WHERE pr.permission.id = :id
    """)
    void deleteAllWherePermission(@Param("id") Integer id);
}
