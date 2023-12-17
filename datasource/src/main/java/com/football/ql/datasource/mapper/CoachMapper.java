package com.football.ql.datasource.mapper;

import com.football.ql.core.model.Coach;
import com.football.ql.datasource.entity.CoachEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {AreaMapper.class, PersonMapper.class})
public interface CoachMapper {
    Coach toModel(CoachEntity entity);
    CoachEntity toEntity(Coach model);
}
