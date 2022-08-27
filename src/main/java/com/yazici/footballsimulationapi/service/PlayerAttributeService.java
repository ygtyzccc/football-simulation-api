package com.yazici.footballsimulationapi.service;

import com.yazici.footballsimulationapi.dto.request.CreatePlayerAttributesRequest;
import com.yazici.footballsimulationapi.dto.response.CreatePlayerAttributesResponse;
import com.yazici.footballsimulationapi.mapper.IPlayerAttributesMapper;
import com.yazici.footballsimulationapi.repository.IPlayerAttributesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerAttributeService {
    private final IPlayerAttributesRepository playerAttributesRepository;
    private final PlayerService playerService;
    private final IPlayerAttributesMapper playerAttributesMapper;

    public CreatePlayerAttributesResponse savePlayerAtt(CreatePlayerAttributesRequest request){
        var playerAtt = playerAttributesMapper.toPlayerAttributes(request);
        var player = playerService.getPlayerByFirstName(request.getFirstName());
        playerAtt.setPlayer(player);

        return playerAttributesMapper.toResponse(playerAttributesRepository.save(playerAtt));


    }

}
