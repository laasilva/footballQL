package com.football.ql.core.port.service;

import com.football.ql.core.model.Team;

import java.util.List;

public interface TeamServiceAdapter {
    Team findTeamByName(String teamName, Boolean sortPlayers);
    List<Team> findTeamsByNameLike(String teamName);
}
