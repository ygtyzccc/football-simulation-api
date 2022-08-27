package com.yazici.footballsimulationapi.service;

import com.yazici.footballsimulationapi.constant.error.LeagueError;
import com.yazici.footballsimulationapi.dto.request.CreateLeagueRequest;
import com.yazici.footballsimulationapi.dto.response.CreateLeagueResponse;
import com.yazici.footballsimulationapi.entity.League;
import com.yazici.footballsimulationapi.exception.LeagueException;
import com.yazici.footballsimulationapi.mapper.ILeagueMapper;
import com.yazici.footballsimulationapi.repository.ILeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LeagueService {
    private final ILeagueRepository leagueRepository;
    private final ILeagueMapper leagueMapper;


    public League getLeagueByName(String name){

        return leagueRepository.findByLeagueName(name).orElseThrow(() -> new LeagueException(LeagueError.NOT_FOUND));
    }

    public CreateLeagueResponse save(CreateLeagueRequest request){

        return leagueMapper.toResponse(leagueRepository.save(leagueMapper.toLeague(request)));
    }

}
