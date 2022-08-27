package com.yazici.footballsimulationapi.dto.response;

import com.yazici.footballsimulationapi.dto.GoalMinuteDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class QueryMatchResponse {
    private String homeTeamName;
    private int homeTeamScore;
    private String awayTeamName;
    private int awayTeamScore;
    private List<GoalMinuteDto> goalMinuteScorerList;



}
