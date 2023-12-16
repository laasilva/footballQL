package com.football.ql.application.controller;

import com.football.ql.core.model.Competition;
import com.football.ql.core.model.Team;
import com.football.ql.core.port.service.CompetitionServiceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionServiceAdapter competitionService;

    @QueryMapping
    public Competition importLeague(@Argument String leagueCode) {
        return competitionService.syncCompetition(leagueCode);
    }
}
