package com.yazici.footballsimulationapi.constant.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PlayerError {
    NOT_FOUND(1001, HttpStatus.NOT_FOUND, "The player could'nt found.");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
