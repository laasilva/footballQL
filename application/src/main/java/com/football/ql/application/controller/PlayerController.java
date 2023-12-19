package com.football.ql.application.controller;

import com.football.ql.core.model.Player;
import com.football.ql.core.port.service.PlayerServiceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerServiceAdapter playerService;
    @QueryMapping
    public List<Player> findPlayers(@Argument String leagueCode, @Argument String teamName) {
        return playerService.findPlayersByLeagueCode(leagueCode, teamName);
    }
    @QueryMapping
    public List<Player> searchPlayer(@Argument String playerName) {
        return playerService.findPlayerByNameLike(playerName);
    }
}
