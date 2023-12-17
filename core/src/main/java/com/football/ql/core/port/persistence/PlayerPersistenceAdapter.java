package com.football.ql.core.port.persistence;

import com.football.ql.core.model.Player;

import java.util.List;

public interface PlayerPersistenceAdapter {
    List<Player> findPlayersByLeagueCode(String leagueCode);
}
