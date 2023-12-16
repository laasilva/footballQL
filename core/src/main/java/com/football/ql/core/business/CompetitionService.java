package com.football.ql.core.business;

import com.football.ql.core.model.Competition;
import com.football.ql.core.model.Team;
import com.football.ql.core.port.persistence.SyncCompetitionPersistenceAdapter;
import com.football.ql.core.port.service.CompetitionServiceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompetitionService implements CompetitionServiceAdapter {

    private final SyncCompetitionPersistenceAdapter syncCompetition;

    @Override
    public Competition syncCompetition(String leagueCode) {
        return syncCompetition.syncCompetition(leagueCode);
    }
}
