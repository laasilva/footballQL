package com.football.ql.core.business;

import com.football.ql.core.model.Player;
import com.football.ql.core.port.persistence.PlayerPersistenceAdapter;
import com.football.ql.core.port.service.PlayerServiceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class PlayerService implements PlayerServiceAdapter {
    private final PlayerPersistenceAdapter playerPersistence;
    @Override
    public List<Player> findPlayersByLeagueCode(String leagueCode) {
        return playerPersistence.findPlayersByLeagueCode(leagueCode);
    }
}
