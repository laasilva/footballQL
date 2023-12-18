package com.football.ql.application.controller;

import com.football.ql.core.model.AvailableLeagues;
import com.football.ql.core.port.service.AvailableLeaguesServiceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AvailableLeaguesController {
    private final AvailableLeaguesServiceAdapter service;
    @QueryMapping
    public List<AvailableLeagues> availableLeaguesForSync() {
        return service.findAllAvailableLeagues();
    }
}
