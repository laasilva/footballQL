package com.football.ql.datasource.persistence;

import com.football.ql.core.model.Competition;
import com.football.ql.core.port.persistence.CompetitionPersistenceAdapter;
import com.football.ql.datasource.mapper.CompetitionMapper;
import com.football.ql.datasource.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompetitionPersistence implements CompetitionPersistenceAdapter {
    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper mapper;

    @Override
    public Competition saveCompetition(Competition competition) {
        var s = competitionRepository.save(mapper.toEntity(competition));
        return mapper.toModel(s);
    }
}
