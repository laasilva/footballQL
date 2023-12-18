package com.football.ql.core.port.persistence;

import com.football.ql.core.model.AvailableLeagues;

import java.util.List;

public interface AvailableLeaguesPersistenceAdapter {
    List<AvailableLeagues> findAllAvailableLeagues();
}
