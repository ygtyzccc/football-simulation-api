package com.yazici.footballsimulationapi.mapper;

import com.yazici.footballsimulationapi.dto.request.CreatePlayerRequest;
import com.yazici.footballsimulationapi.dto.response.CreatePlayerResponse;
import com.yazici.footballsimulationapi.entity.Player;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PlayerMapperImpl", componentModel = "spring")
public interface IPlayerMapper {
    Player toPlayer(CreatePlayerRequest request);
    CreatePlayerResponse toResponse(Player player);

}
