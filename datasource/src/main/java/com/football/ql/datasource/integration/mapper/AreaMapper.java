package com.football.ql.datasource.integration.mapper;

import com.football.ql.core.model.Area;
import com.football.ql.core.pojo.AreaPojo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface AreaMapper {
    Area toModel(AreaPojo pojo);
}
