package com.football.ql.datasource.mapper;

import com.football.ql.core.model.Team;
import com.football.ql.datasource.entity.TeamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {AreaMapper.class,
                CoachMapper.class,
                PlayerMapper.class,
                PersonMapper.class})
public interface TeamMapper {
    Team toModel(TeamEntity entity);
    TeamEntity toEntity(Team team);
}
