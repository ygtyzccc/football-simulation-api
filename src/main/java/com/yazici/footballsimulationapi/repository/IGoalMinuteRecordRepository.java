package com.yazici.footballsimulationapi.repository;

import com.yazici.footballsimulationapi.entity.GoalMinuteRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGoalMinuteRecordRepository extends JpaRepository<GoalMinuteRecord, Long> {
}
