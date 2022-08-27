package com.yazici.footballsimulationapi.exception;

import com.yazici.footballsimulationapi.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MatchException.class)
    protected ResponseEntity<ErrorResponse> handleMatchException(MatchException ex){

        return ResponseEntity.status(ex.getMatchError().getHttpStatus())
                .body(ErrorResponse.builder()
                        .code(ex.getMatchError().getCode())
                        .message(ex.getMessage())
                        .build());

    }

    @ExceptionHandler(PlayerException.class)
    protected ResponseEntity<ErrorResponse> handlePlayerException(PlayerException ex){

        return ResponseEntity.status(ex.getPlayerError().getHttpStatus())
                .body(ErrorResponse.builder()
                        .code(ex.getPlayerError().getCode())
                        .message(ex.getMessage())
                        .build());

    }

    @ExceptionHandler(LeagueException.class)
    protected ResponseEntity<ErrorResponse> handleLeagueException(LeagueException ex){

        return ResponseEntity.status(ex.getLeagueError().getHttpStatus())
                .body(ErrorResponse.builder()
                        .code(ex.getLeagueError().getCode())
                        .message(ex.getMessage())
                        .build());

    }

    @ExceptionHandler(TeamException.class)
    protected ResponseEntity<ErrorResponse> handleTeamException(TeamException ex){

        return ResponseEntity.status(ex.getTeamError().getHttpStatus())
                .body(ErrorResponse.builder()
                        .code(ex.getTeamError().getCode())
                        .message(ex.getMessage())
                        .build());

    }




}
