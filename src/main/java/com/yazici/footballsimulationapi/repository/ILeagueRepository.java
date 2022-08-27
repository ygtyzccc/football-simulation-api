package com.yazici.footballsimulationapi.repository;

import com.yazici.footballsimulationapi.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ILeagueRepository extends JpaRepository<League, Long> {

    Optional<League> findByLeagueName(String leagueName);
}
