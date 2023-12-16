package com.football.ql.application.config;

import com.football.ql.core.business.CompetitionService;
import com.football.ql.core.port.persistence.SyncCompetitionPersistenceAdapter;
import com.football.ql.core.port.service.CompetitionServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.football.ql"})
public class BeanConfig {
    @Bean
    CompetitionServiceAdapter competitionService(SyncCompetitionPersistenceAdapter syncCompetitionPersistenceAdapter) {
        return new CompetitionService(syncCompetitionPersistenceAdapter);
    }
}
