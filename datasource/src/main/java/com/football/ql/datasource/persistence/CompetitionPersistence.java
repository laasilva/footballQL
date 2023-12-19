package com.football.ql.datasource.persistence;

import com.football.ql.core.model.Competition;
import com.football.ql.core.port.persistence.CompetitionPersistenceAdapter;
import com.football.ql.datasource.entity.CompetitionEntity;
import com.football.ql.datasource.mapper.CompetitionMapper;
import com.football.ql.datasource.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompetitionPersistence implements CompetitionPersistenceAdapter {
    private final CompetitionRepository competitionRepository;
    private final AreaRepository areaRepository;
    private final CompetitionMapper mapper;

    @Override
    public Competition saveCompetition(Competition competition) {
        var entity = mapper.toEntity(competition);
        saveArea(entity);
        var s = competitionRepository.save(entity);
        return mapper.toModel(s);
    }

    private void saveArea(CompetitionEntity entity) {
        var competitionArea = areaRepository.saveAndFlush(entity.getArea());
        entity.setArea(competitionArea);
        entity.getTeams().forEach(team -> {
            var teamArea = areaRepository.saveAndFlush(team.getArea());
            team.setArea(teamArea);
        });
    }
}
