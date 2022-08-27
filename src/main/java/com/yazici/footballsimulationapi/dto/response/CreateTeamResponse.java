package com.yazici.footballsimulationapi.dto.response;

import lombok.Data;

@Data
public class CreateTeamResponse {
    private String teamName;
    private String leagueName;
    private String teamCodeName;

}
