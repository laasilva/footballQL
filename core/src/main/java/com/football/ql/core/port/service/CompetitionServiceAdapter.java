package com.football.ql.core.port.service;

import com.football.ql.core.model.Competition;
import com.football.ql.core.model.Team;

import java.util.List;

public interface CompetitionServiceAdapter {
    Competition syncCompetition(String leagueCode);
}
