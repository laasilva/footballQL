package com.football.ql.datasource.repository;

import com.football.ql.datasource.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    @Query("SELECT p FROM PlayerEntity p " +
            "JOIN FETCH p.team t " +
            "JOIN FETCH t.competitions c " +
            "WHERE c.code = :leagueCode")
    List<PlayerEntity> findPlayerListByLeagueCode(String leagueCode);
}
