package com.football.ql.datasource.persistence;

import com.football.ql.core.model.Competition;
import com.football.ql.core.model.Team;
import com.football.ql.core.port.persistence.SyncCompetitionPersistenceAdapter;
import com.football.ql.datasource.integration.football_data.SyncCompetition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SyncCompetitionPersistence implements SyncCompetitionPersistenceAdapter {
    private final SyncCompetition sync;

    @Override
    public Competition syncCompetition(String leagueCode) {
        var competition = sync.syncCompetition(leagueCode);
        var teams = syncTeamsFromCompetition(leagueCode);

        if (teams != null) {
            competition.setTeams(teams);
        }

        return competition;
    }

    private List<Team> syncTeamsFromCompetition(String leagueCode) {
        return sync.syncCompetitionTeams(leagueCode);
    }
}
