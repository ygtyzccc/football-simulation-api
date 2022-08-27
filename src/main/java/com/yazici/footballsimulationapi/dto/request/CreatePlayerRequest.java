package com.yazici.footballsimulationapi.dto.request;

import com.yazici.footballsimulationapi.entity.enums.PlayerPosition;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlayerRequest {

    private String firstName;
    private String lastName;
    private String teamCodeName;
    private PlayerPosition position;
}
