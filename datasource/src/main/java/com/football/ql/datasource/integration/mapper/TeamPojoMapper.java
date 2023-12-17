package com.football.ql.datasource.integration.mapper;

import com.football.ql.core.model.Team;
import com.football.ql.core.pojo.TeamPojo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = {PlayerPojoMapper.class, CoachPojoMapper.class, AreaPojoMapper.class})
public interface TeamPojoMapper {
    Team toModel(TeamPojo pojo);
}
