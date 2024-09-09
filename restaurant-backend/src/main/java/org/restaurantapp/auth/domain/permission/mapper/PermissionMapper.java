package org.restaurantapp.auth.domain.permission.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.restaurantapp.auth.domain.permission.Permission;
import org.restaurantapp.auth.domain.permission.dto.PermissionDto;

@Mapper
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    PermissionDto mapToDto(Permission permission);
}
