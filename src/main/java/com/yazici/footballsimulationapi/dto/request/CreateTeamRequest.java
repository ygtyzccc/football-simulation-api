package com.yazici.footballsimulationapi.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTeamRequest {
    private String teamName;
    private String teamCodeName;
    private String leagueName;

}
