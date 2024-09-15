package org.restaurantapp.auth.domain.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.restaurantapp.auth.domain.role.Role;
import org.restaurantapp.auth.domain.role.dto.RoleDto;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto mapFromEntity(Role role);
}
