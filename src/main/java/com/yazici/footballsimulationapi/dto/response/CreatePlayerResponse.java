package com.yazici.footballsimulationapi.dto.response;

import com.yazici.footballsimulationapi.entity.enums.PlayerPosition;
import lombok.Data;

@Data
public class CreatePlayerResponse {
    private String firstName;
    private String lastName;
    private String teamName;
    private PlayerPosition position;

}
