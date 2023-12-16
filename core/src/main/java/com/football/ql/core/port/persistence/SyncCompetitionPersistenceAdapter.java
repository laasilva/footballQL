package com.football.ql.core.port.persistence;

import com.football.ql.core.model.Competition;
import com.football.ql.core.model.Team;

import java.util.List;

public interface SyncCompetitionPersistenceAdapter {
    Competition syncCompetition(String leagueCode);
}
