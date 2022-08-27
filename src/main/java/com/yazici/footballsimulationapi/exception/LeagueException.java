package com.yazici.footballsimulationapi.exception;

import com.yazici.footballsimulationapi.constant.error.LeagueError;
import lombok.Getter;

@Getter
public class LeagueException extends RuntimeException{
    private final LeagueError leagueError;

    public LeagueException(LeagueError leagueError){

        super(leagueError.getMessage());
        this.leagueError = leagueError;

    }
}
