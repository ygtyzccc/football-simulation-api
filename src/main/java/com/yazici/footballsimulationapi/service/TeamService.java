package com.yazici.footballsimulationapi.service;

import com.yazici.footballsimulationapi.constant.error.TeamError;
import com.yazici.footballsimulationapi.dto.request.CreateTeamRequest;
import com.yazici.footballsimulationapi.dto.response.CreateTeamResponse;
import com.yazici.footballsimulationapi.entity.Team;
import com.yazici.footballsimulationapi.exception.TeamException;
import com.yazici.footballsimulationapi.mapper.ITeamMapper;
import com.yazici.footballsimulationapi.repository.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final LeagueService leagueService;
    private final ITeamRepository teamRepository;
    private final ITeamMapper teamMapper;

    public Team getTeamByTeamCodeName(String teamCodeName){

        return teamRepository.findTeamByTeamCodeName(teamCodeName)
                .orElseThrow(() -> new TeamException(TeamError.NOT_FOUND));
    }

    public Team getTeamById(Long id){

        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamException(TeamError.NOT_FOUND));
    }



    public CreateTeamResponse save(CreateTeamRequest request){

        var team = teamMapper.toTeam(request);
        var league = leagueService.getLeagueByName(request.getLeagueName());
        team.setLeague(league);
        var response =  teamMapper.toResponse(teamRepository.save(team));
        response.setLeagueName(request.getLeagueName());
        return response;


    }

}
