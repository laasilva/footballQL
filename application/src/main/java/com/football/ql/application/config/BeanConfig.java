package com.football.ql.application.config;

import com.football.ql.core.business.AvailableLeaguesService;
import com.football.ql.core.business.CompetitionService;
import com.football.ql.core.business.PlayerService;
import com.football.ql.core.business.TeamService;
import com.football.ql.core.port.persistence.*;
import com.football.ql.core.port.service.AvailableLeaguesServiceAdapter;
import com.football.ql.core.port.service.CompetitionServiceAdapter;
import com.football.ql.core.port.service.PlayerServiceAdapter;
import com.football.ql.core.port.service.TeamServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.football.ql"})
public class BeanConfig {
    @Bean
    CompetitionServiceAdapter competitionService(SyncCompetitionPersistenceAdapter syncCompetitionPersistenceAdapter,
                                                 CompetitionPersistenceAdapter competitionPersistenceAdapter) {
        return new CompetitionService(syncCompetitionPersistenceAdapter, competitionPersistenceAdapter);
    }

    @Bean
    PlayerServiceAdapter playerService(PlayerPersistenceAdapter playerPersistenceAdapter) {
        return new PlayerService(playerPersistenceAdapter);
    }

    @Bean
    TeamServiceAdapter teamService(TeamPersistenceAdapter teamPersistenceAdapter) {
        return new TeamService(teamPersistenceAdapter);
    }

    @Bean
    AvailableLeaguesServiceAdapter availableLeaguesService(AvailableLeaguesPersistenceAdapter
                                                                   availableLeaguesPersistenceAdapter) {
        return new AvailableLeaguesService(availableLeaguesPersistenceAdapter);
    }
}
