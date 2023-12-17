package com.football.ql.datasource.mapper;

import com.football.ql.core.model.Competition;
import com.football.ql.datasource.entity.AreaEntity;
import com.football.ql.datasource.entity.CompetitionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {AreaMapper.class,
                TeamMapper.class,
                CoachMapper.class,
                PlayerMapper.class,
                PersonMapper.class})
public interface CompetitionMapper {
    Competition toModel(CompetitionEntity entity);
    CompetitionEntity toEntity(Competition model);
}
