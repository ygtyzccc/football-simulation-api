package com.yazici.footballsimulationapi.exception;

import com.yazici.footballsimulationapi.constant.error.TeamError;
import lombok.Getter;

@Getter
public class TeamException extends RuntimeException{

    private final TeamError teamError;

    public TeamException(TeamError teamError){
        super(teamError.getMessage());
        this.teamError = teamError;

    }
}
