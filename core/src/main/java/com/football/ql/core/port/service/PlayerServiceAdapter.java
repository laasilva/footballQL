package com.football.ql.core.port.service;

import com.football.ql.core.model.Player;

import java.util.List;

public interface PlayerServiceAdapter {
    List<Player> findPlayersByLeagueCode(String leagueCode, String teamName);
    List<Player> findPlayerByNameLike(String playerName);
}
