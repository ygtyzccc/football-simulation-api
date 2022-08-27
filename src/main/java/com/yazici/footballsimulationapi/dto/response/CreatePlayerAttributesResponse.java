package com.yazici.footballsimulationapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlayerAttributesResponse {

    private int attack;
    private int defence;
    private int keepingAtt;
}
