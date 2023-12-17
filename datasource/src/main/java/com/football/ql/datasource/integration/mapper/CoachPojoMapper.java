package com.football.ql.datasource.integration.mapper;

import com.football.ql.core.model.Coach;
import com.football.ql.core.model.Person;
import com.football.ql.core.pojo.CoachPojo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CoachPojoMapper {
    default Coach toModel(CoachPojo pojo) {
        Coach model = new Coach();

        model.setId(pojo.getId());
        model.setPerson(Person.builder()
                .dateOfBirth(pojo.getDateOfBirth())
                .name(pojo.getName() == null ?
                        String.format(pojo.getFirstName() + " " + pojo.getLastName()) : pojo.getName())
                .nationality(pojo.getNationality())
                .gamePosition("Coach")
                .build());

        return model;
    }
}
