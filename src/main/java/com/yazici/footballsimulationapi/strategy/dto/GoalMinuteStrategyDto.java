package com.yazici.footballsimulationapi.strategy.dto;

import com.yazici.footballsimulationapi.entity.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoalMinuteStrategyDto {
    private int minute;
    private Player player;
}
