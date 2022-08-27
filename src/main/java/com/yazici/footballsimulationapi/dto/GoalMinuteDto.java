package com.yazici.footballsimulationapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GoalMinuteDto {
    private int minute;
    private String playerFullName;
}
