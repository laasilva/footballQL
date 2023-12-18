package com.football.ql.core.business;

import com.football.ql.core.model.Player;
import com.football.ql.core.model.Team;
import com.football.ql.core.port.persistence.TeamPersistenceAdapter;
import com.football.ql.core.port.service.TeamServiceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class TeamService implements TeamServiceAdapter {
    private final TeamPersistenceAdapter teamPersistence;
    @Override
    public Team findTeamByName(String teamName, Boolean sortPlayers) {
        var team = teamPersistence.findTeamByName(teamName);
        if (sortPlayers != null && sortPlayers) {
            team.getPlayers().sort(Comparator.comparing(player -> player.getPerson().getName()));
        }

        return team;
    }

    @Override
    public List<Team> findTeamsByNameLike(String teamName) {
        return teamPersistence.findTeamByNameLike(teamName);
    }
}
