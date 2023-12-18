package com.football.ql.core.business;

import com.football.ql.core.model.AvailableLeagues;
import com.football.ql.core.port.persistence.AvailableLeaguesPersistenceAdapter;
import com.football.ql.core.port.service.AvailableLeaguesServiceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AvailableLeaguesService implements AvailableLeaguesServiceAdapter {
    private final AvailableLeaguesPersistenceAdapter persistence;

    @Override
    public List<AvailableLeagues> findAllAvailableLeagues() {
        return persistence.findAllAvailableLeagues();
    }
}
