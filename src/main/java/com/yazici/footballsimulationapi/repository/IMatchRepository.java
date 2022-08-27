package com.yazici.footballsimulationapi.repository;

import com.yazici.footballsimulationapi.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatchRepository extends JpaRepository<Match, Long> {
}
