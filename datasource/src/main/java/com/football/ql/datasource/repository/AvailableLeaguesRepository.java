package com.football.ql.datasource.repository;

import com.football.ql.datasource.entity.AvailableLeaguesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableLeaguesRepository extends JpaRepository<AvailableLeaguesEntity, String> {
}
