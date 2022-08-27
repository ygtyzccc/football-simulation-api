package com.yazici.footballsimulationapi.constant.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum LeagueError {
    NOT_FOUND(2001, HttpStatus.NOT_FOUND, "The league not found");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
