package com.football.ql.datasource.mapper;

import com.football.ql.core.model.Player;
import com.football.ql.datasource.entity.PlayerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {AreaMapper.class, PersonMapper.class})
public interface PlayerMapper {
    Player toModel(PlayerEntity entity);
    PlayerEntity toEntity(Player model);
}
