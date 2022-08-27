package com.yazici.footballsimulationapi.repository;

import com.yazici.footballsimulationapi.entity.PlayerAttributes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerAttributesRepository extends JpaRepository<PlayerAttributes, Long> {
}
