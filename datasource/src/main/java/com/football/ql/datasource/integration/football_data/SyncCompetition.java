package com.football.ql.datasource.integration.football_data;


import com.football.ql.core.model.Competition;
import com.football.ql.core.model.Team;
import com.football.ql.core.pojo.CompetitionResponsePojo;
import com.football.ql.core.pojo.TeamResponsePojo;
import com.football.ql.datasource.integration.mapper.CompetitionMapper;
import com.football.ql.datasource.integration.mapper.TeamMapper;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Log4j2
public class SyncCompetition {
    private final String token;
    private final String requestURI;
    private final WebClient.Builder webClientBuilder;
    private final TeamMapper teamMapper;
    private final CompetitionMapper competitionMapper;
    public SyncCompetition(@Value("${football-data.token}") String token,
                           @Value("${football-data.uri}") String requestURI,
                           WebClient.Builder webClientBuilder,
                           TeamMapper teamMapper, CompetitionMapper competitionMapper) {
        this.token = token;
        this.requestURI = requestURI;
        this.webClientBuilder = webClientBuilder;
        this.teamMapper = teamMapper;
        this.competitionMapper = competitionMapper;
    }
    public Competition syncCompetition(String leagueCode) {
        var uri = String.format(requestURI + "/competitions/%s", leagueCode);

        var response = webClientBuilder
                .build()
                .get()
                .uri(uri)
                .header("X-Auth-Token", token)
                .exchangeToMono(resp -> {
                    if (resp.statusCode() != HttpStatus.OK) {
//                        log.error("Error while requesting from " + uri);
//                        log.error("Status code: " + resp.statusCode());

                        throw new HttpClientErrorException(resp.statusCode());
                    }
                    return resp.bodyToMono(String.class);
                })
                .toFuture();

        return competitionJsonToModel(response.join());
    }

    public List<Team> syncCompetitionTeams(String leagueCode) {
        var uri = String.format(requestURI + "/competitions/%s/teams", leagueCode);

        var response = webClientBuilder
                .build()
                .get()
                .uri(uri)
                .header("X-Auth-Token", token)
                .exchangeToMono(resp -> {
                    if (resp.statusCode() != HttpStatus.OK) {
//                        log.error("Error while requesting from " + uri);
//                        log.error("Status code: " + resp.statusCode());

                        throw new HttpClientErrorException(resp.statusCode());
                    }
                    return resp.bodyToMono(String.class);
                })
                .toFuture();

        return teamJsonToModel(response.join());
    }

    private List<Team> teamJsonToModel(String response) {
        var pojo = new Gson().fromJson(response, TeamResponsePojo.class);
        return pojo.getTeams().stream().map(teamMapper::toModel).collect(Collectors.toList());
    }

    private Competition competitionJsonToModel(String response) {
        var pojo = new Gson().fromJson(response, CompetitionResponsePojo.class);
        return competitionMapper.toModel(pojo);
    }
}
