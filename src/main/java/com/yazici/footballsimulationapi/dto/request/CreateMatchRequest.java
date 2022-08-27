package com.yazici.footballsimulationapi.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMatchRequest {
    private String homeTeamCodeName;
    private String awayTeamCodeName;
}
