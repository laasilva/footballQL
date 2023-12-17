package com.football.ql.datasource.integration.football_data;

import com.football.ql.core.exception.IntegrationException;
import com.football.ql.core.exception.model.ErrorMessage;
import com.football.ql.core.model.Competition;
import com.football.ql.core.model.Team;
import com.football.ql.core.pojo.CompetitionResponsePojo;
import com.football.ql.core.pojo.TeamResponsePojo;
import com.football.ql.datasource.integration.mapper.CompetitionPojoMapper;
import com.football.ql.datasource.integration.mapper.TeamPojoMapper;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SyncCompetition {
    private final String token;
    private final String requestURI;
    private final WebClient.Builder webClientBuilder;
    private final TeamPojoMapper teamPojoMapper;
    private final CompetitionPojoMapper competitionPojoMapper;
    public SyncCompetition(@Value("${football-data.token}") String token,
                           @Value("${football-data.uri}") String requestURI,
                           WebClient.Builder webClientBuilder,
                           TeamPojoMapper teamPojoMapper, CompetitionPojoMapper competitionPojoMapper) {
        this.token = token;
        this.requestURI = requestURI;
        this.webClientBuilder = webClientBuilder;
        this.teamPojoMapper = teamPojoMapper;
        this.competitionPojoMapper = competitionPojoMapper;
    }
    public Competition syncCompetition(String leagueCode) {
        var uri = String.format(requestURI + "/competitions/%s", leagueCode.toUpperCase());

        var response = webClientBuilder
                .build()
                .get()
                .uri(uri)
                .header("X-Auth-Token", token)
                .exchangeToMono(resp -> {
                    if (resp.statusCode() != HttpStatus.OK) {
                        log.error("Error while requesting from " + uri);
                        log.error("Status code: " + resp.statusCode());

                        throw new IntegrationException(ErrorMessage.SYNC_ERROR.getCode(),
                                ErrorMessage.SYNC_ERROR.getMessage());
                    }
                    return resp.bodyToMono(String.class);
                })
                .toFuture();

        return competitionJsonToModel(response.join());
    }

    public List<Team> syncCompetitionTeams(String leagueCode) {
        var uri = String.format(requestURI + "/competitions/%s/teams", leagueCode.toUpperCase());

        var response = webClientBuilder
                .build()
                .get()
                .uri(uri)
                .header("X-Auth-Token", token)
                .exchangeToMono(resp -> {
                    if (resp.statusCode() != HttpStatus.OK) {
                        log.error("Error while requesting from " + uri);
                        log.error("Status code: " + resp.statusCode());

                        throw new IntegrationException(ErrorMessage.SYNC_ERROR.getCode(),
                                ErrorMessage.SYNC_ERROR.getMessage());
                    }
                    return resp.bodyToMono(String.class);
                })
                .toFuture();

        return teamJsonToModel(response.join());
    }

    private List<Team> teamJsonToModel(String response) {
        var pojo = new Gson().fromJson(response, TeamResponsePojo.class);
        return pojo.getTeams().stream().map(teamPojoMapper::toModel).collect(Collectors.toList());
    }

    private Competition competitionJsonToModel(String response) {
        var pojo = new Gson().fromJson(response, CompetitionResponsePojo.class);
        return competitionPojoMapper.toModel(pojo);
    }
}
