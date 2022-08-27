package com.yazici.footballsimulationapi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PlayMatchResponse {
    private String homeTeamCodeName;
    private String awayTeamCodeName;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private LocalDateTime matchDateTime;
}
