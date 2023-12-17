package com.football.ql.core.port.persistence;

import com.football.ql.core.model.Competition;

public interface CompetitionPersistenceAdapter {
    Competition saveCompetition(Competition competition);
}
