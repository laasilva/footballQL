package com.football.ql.datasource.persistence;

import com.football.ql.core.exception.PersistenceException;
import com.football.ql.core.exception.model.ErrorMessage;
import com.football.ql.core.model.Team;
import com.football.ql.core.port.persistence.TeamPersistenceAdapter;
import com.football.ql.datasource.mapper.TeamMapper;
import com.football.ql.datasource.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeamPersistence implements TeamPersistenceAdapter {
    private final TeamRepository repository;
    private final TeamMapper mapper;
    @Override
    public Team findTeamByName(String teamName) {
        var entity = repository.findTeamByName(teamName);

        if(entity != null) {
            return mapper.toModel(entity);
        }

        throw new PersistenceException(ErrorMessage.INVALID_TEAM_NAME.getCode(),
                ErrorMessage.INVALID_TEAM_NAME.getMessage());
    }

    @Override
    public List<Team> findTeamByNameLike(String teamName) {
        var entities = repository.findAllByNameLike("%" + teamName + "%");

        if (entities != null) {
            return entities.stream().map(mapper::toModel).collect(Collectors.toList());
        }

        throw new PersistenceException(ErrorMessage.INVALID_TEAM_NAME.getCode(),
                ErrorMessage.INVALID_TEAM_NAME.getMessage());
    }
}
