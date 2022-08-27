package com.yazici.footballsimulationapi.exception;

import com.yazici.footballsimulationapi.constant.error.PlayerError;
import lombok.Getter;

@Getter
public class PlayerException extends RuntimeException{

    private final PlayerError playerError;

    public PlayerException(PlayerError playerError){
        super(playerError.getMessage());
        this.playerError = playerError;
    }
}
