package com.yazici.footballsimulationapi.repository;

import com.yazici.footballsimulationapi.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface IPlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findPlayerByFirstName(String firstName);
}
