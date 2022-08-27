package com.yazici.footballsimulationapi.service;

import com.yazici.footballsimulationapi.constant.error.PlayerError;
import com.yazici.footballsimulationapi.dto.request.CreatePlayerRequest;
import com.yazici.footballsimulationapi.dto.response.CreatePlayerResponse;
import com.yazici.footballsimulationapi.entity.Player;
import com.yazici.footballsimulationapi.exception.PlayerException;
import com.yazici.footballsimulationapi.mapper.IPlayerMapper;
import com.yazici.footballsimulationapi.repository.IPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final IPlayerRepository playerRepository;
    private final IPlayerMapper playerMapper;
    private final TeamService teamService;

    public Player getPlayerById(Long id){
        return  playerRepository.findById(id).orElseThrow(() -> new PlayerException(PlayerError.NOT_FOUND));

    }

    public Player getPlayerByFirstName(String firstName){

        return playerRepository.findPlayerByFirstName(firstName).orElseThrow(() -> new PlayerException(PlayerError.NOT_FOUND));
    }

    public CreatePlayerResponse save(CreatePlayerRequest createPlayerRequest) {
        var player = playerMapper.toPlayer(createPlayerRequest);
        var team = teamService.getTeamByTeamCodeName(createPlayerRequest.getTeamCodeName());
        player.setTeam(team);

        var response =  playerMapper.toResponse(playerRepository.save(player));
        response.setTeamName(team.getTeamName());

        return response;
    }


}
