package com.football.ql.datasource.integration.mapper;

import com.football.ql.core.model.Person;
import com.football.ql.core.model.Player;
import com.football.ql.core.model.Position;
import com.football.ql.core.pojo.PlayerPojo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface PlayerMapper {
    default Player toModel(PlayerPojo pojo) {
        Player model = new Player();

        model.setId(pojo.getId());
        model.setPerson(Person.builder()
                        .dateOfBirth(pojo.getDateOfBirth())
                        .name(pojo.getName())
                        .nationality(pojo.getNationality())
                        .position(pojo.getPosition())
            .build());

        return model;
    }
}
