package com.football.ql.datasource.repository;

import com.football.ql.datasource.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    TeamEntity findTeamByName(String teamName);
    List<TeamEntity> findAllByNameLike(String teamName);
}
