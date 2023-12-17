package com.football.ql.datasource.mapper;

import com.football.ql.core.model.Area;
import com.football.ql.datasource.entity.AreaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaMapper {
    Area toModel(AreaEntity entity);
    AreaEntity toEntity(Area model);
}
