package com.yazici.footballsimulationapi.mapper;

import com.yazici.footballsimulationapi.dto.request.CreatePlayerAttributesRequest;
import com.yazici.footballsimulationapi.dto.response.CreatePlayerAttributesResponse;
import com.yazici.footballsimulationapi.entity.PlayerAttributes;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PlayerAttributesMapperImpl", componentModel = "spring")
public interface IPlayerAttributesMapper {
    PlayerAttributes toPlayerAttributes(CreatePlayerAttributesRequest request);
    CreatePlayerAttributesResponse toResponse(PlayerAttributes playerAttributes);

}
