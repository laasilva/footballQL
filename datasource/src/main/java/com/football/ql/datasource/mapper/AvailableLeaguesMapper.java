package com.football.ql.datasource.mapper;

import com.football.ql.core.model.AvailableLeagues;
import com.football.ql.datasource.entity.AvailableLeaguesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailableLeaguesMapper {
    AvailableLeagues toModel(AvailableLeaguesEntity entity);
}
