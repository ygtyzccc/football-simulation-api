package com.yazici.footballsimulationapi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateMatchResponse {
    private String homeTeamCodeName;
    private String awayTeamCodeName;
    private LocalDateTime matchDateTime;
}
