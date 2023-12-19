package com.football.ql.core.port.service;

import com.football.ql.core.model.AvailableLeagues;

import java.util.List;

public interface AvailableLeaguesServiceAdapter {
    List<AvailableLeagues> findAllAvailableLeagues();
}
