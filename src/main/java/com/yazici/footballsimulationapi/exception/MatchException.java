package com.yazici.footballsimulationapi.exception;

import com.yazici.footballsimulationapi.constant.error.MatchError;
import lombok.Getter;

@Getter
public class MatchException extends RuntimeException{

    private final MatchError matchError;

    public MatchException(MatchError matchError){
        super(matchError.getMessage());
        this.matchError = matchError;
    }
}
