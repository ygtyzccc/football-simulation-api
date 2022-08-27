package com.yazici.footballsimulationapi.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlayerAttributesRequest {

    private String firstName;
    private Long playerId;
    private int attack;
    private int defence;
    private int keepingAtt;
}
