package com.football.ql.datasource.repository;

import com.football.ql.datasource.entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<CompetitionEntity, Long> {
}
