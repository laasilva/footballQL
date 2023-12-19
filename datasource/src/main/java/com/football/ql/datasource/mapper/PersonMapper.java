package com.football.ql.datasource.mapper;

import com.football.ql.core.model.Person;
import com.football.ql.datasource.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toModel(PersonEntity entity);
    PersonEntity toEntity(Person model);
}
