package com.yazici.footballsimulationapi.repository;

import com.yazici.footballsimulationapi.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findTeamByTeamCodeName(String teamCodeName);
}
