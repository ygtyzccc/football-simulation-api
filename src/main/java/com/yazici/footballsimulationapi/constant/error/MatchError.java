package com.yazici.footballsimulationapi.constant.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MatchError {
    NOT_FOUND(3001, HttpStatus.NOT_FOUND, "The match is not found"),
    MATCH_ALREADY_PLAYED(3002, HttpStatus.BAD_REQUEST, "The match had been played already");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
