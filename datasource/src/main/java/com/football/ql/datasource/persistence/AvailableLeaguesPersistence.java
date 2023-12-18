package com.football.ql.datasource.persistence;

import com.football.ql.core.model.AvailableLeagues;
import com.football.ql.core.port.persistence.AvailableLeaguesPersistenceAdapter;
import com.football.ql.datasource.mapper.AvailableLeaguesMapper;
import com.football.ql.datasource.repository.AvailableLeaguesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AvailableLeaguesPersistence implements AvailableLeaguesPersistenceAdapter {
    private final AvailableLeaguesRepository repository;
    private final AvailableLeaguesMapper mapper;

    @Override
    public List<AvailableLeagues> findAllAvailableLeagues() {
        var entities = repository.findAll();
        return entities.stream().map(mapper::toModel).collect(Collectors.toList());
    }
}
