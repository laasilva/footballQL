package com.football.ql.datasource.persistence;

import com.football.ql.core.exception.PersistenceException;
import com.football.ql.core.exception.model.ErrorMessage;
import com.football.ql.core.model.Player;
import com.football.ql.core.port.persistence.PlayerPersistenceAdapter;
import com.football.ql.datasource.mapper.PlayerMapper;
import com.football.ql.datasource.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlayerPersistence implements PlayerPersistenceAdapter {
    private final PlayerRepository repository;
    private final PlayerMapper mapper;
    @Override
    public List<Player> findPlayersByLeagueCode(String leagueCode) {
        var result = repository.findPlayerListByLeagueCode(leagueCode);
        if (!result.isEmpty()) {
            return result.stream().map(mapper::toModel).collect(Collectors.toList());
        }

        throw new PersistenceException(ErrorMessage.INVALID_LEAGUE_CODE.getCode(),
                ErrorMessage.INVALID_LEAGUE_CODE.getMessage());
    }

    @Override
    public List<Player> findPlayersByLeagueCodeAndTeamName(String leagueCode, String teamName) {
        var result = repository.findPlayerListByLeagueCodeAndTeam(leagueCode, teamName);

        if (!result.isEmpty()) {
            return result.stream().map(mapper::toModel).collect(Collectors.toList());
        }

        throw new PersistenceException(ErrorMessage.INVALID_TEAM_NAME.getCode(),
                ErrorMessage.INVALID_TEAM_NAME.getMessage());
    }

    @Override
    public List<Player> findPlayerByNameLike(String playerName) {
        var result = repository.findAllByPersonNameLike("%" + playerName + "%");

        if (!result.isEmpty()) {
            return result.stream().map(mapper::toModel).collect(Collectors.toList());
        }

        throw new PersistenceException(ErrorMessage.INVALID_PLAYER_NAME.getCode(),
                ErrorMessage.INVALID_PLAYER_NAME.getMessage());
    }
}
