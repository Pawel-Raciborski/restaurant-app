package org.restaurantapp.auth.domain.permission.repository;

import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.RolePermission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission,Integer> {
    @Modifying
    @Query("""
    DELETE RolePermission pr WHERE pr.permission.id = :id
    """)
    void deleteAllWherePermission(@Param("id") Integer id);

    @Query(
    """
    SELECT p FROM RolePermission rp
    INNER JOIN rp.permission p
    INNER JOIN rp.role r
    WHERE r.name = :roleName
    """)
    List<Permission> findPermissionsForRole(@Param("roleName") String roleName, Pageable pageable);
}
