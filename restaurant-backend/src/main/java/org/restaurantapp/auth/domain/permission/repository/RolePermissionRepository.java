package org.restaurantapp.auth.domain.permission.repository;

import org.restaurantapp.auth.domain.permission.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolePermissionRepository extends JpaRepository<RolePermission,Integer> {
    @Modifying
    @Query("""
    DELETE RolePermission pr WHERE pr.permission.id = :id
    """)
    void deleteAllWherePermission(@Param("id") Integer id);
}
