package com.football.ql.datasource.persistence;

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

        return result.stream().map(mapper::toModel).collect(Collectors.toList());
    }
}
