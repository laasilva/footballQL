package com.football.ql.application.controller;

import com.football.ql.core.model.Team;
import com.football.ql.core.port.service.PlayerServiceAdapter;
import com.football.ql.core.port.service.TeamServiceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {
    private final TeamServiceAdapter teamService;

    @QueryMapping
    public Team findTeam(@Argument String teamName, @Argument Boolean sortPlayers) {
        return teamService.findTeamByName(teamName, sortPlayers);
    }
    @QueryMapping
    public List<Team> searchTeam(@Argument String teamName) {
        return teamService.findTeamsByNameLike(teamName);
    }
}
