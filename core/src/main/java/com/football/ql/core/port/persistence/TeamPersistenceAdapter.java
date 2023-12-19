package com.football.ql.core.port.persistence;

import com.football.ql.core.model.Team;

import java.util.List;

public interface TeamPersistenceAdapter {
    Team findTeamByName(String teamName);
    List<Team> findTeamByNameLike(String teamName);
}
