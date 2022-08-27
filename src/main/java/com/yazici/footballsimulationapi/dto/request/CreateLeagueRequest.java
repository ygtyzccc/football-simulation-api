package com.yazici.footballsimulationapi.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLeagueRequest {

    private String leagueName;
    private String country;

}
