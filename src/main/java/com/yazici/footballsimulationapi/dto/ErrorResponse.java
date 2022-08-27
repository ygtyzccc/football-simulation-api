package com.yazici.footballsimulationapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private Integer code;
    private String message;
}
