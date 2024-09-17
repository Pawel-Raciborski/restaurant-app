package org.restaurantapp.worker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.restaurantapp.worker.domain.Worker;
import org.restaurantapp.worker.dto.WorkerDto;

@Mapper
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    WorkerDto mapFromEntity(Worker worker);
}
