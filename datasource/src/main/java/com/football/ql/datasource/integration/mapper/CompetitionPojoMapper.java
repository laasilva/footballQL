package com.football.ql.datasource.integration.mapper;

import com.football.ql.core.model.Competition;
import com.football.ql.core.pojo.CompetitionResponsePojo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = {AreaPojoMapper.class})
public interface CompetitionPojoMapper {
    Competition toModel(CompetitionResponsePojo pojo);
}
