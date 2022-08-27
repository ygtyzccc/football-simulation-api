package com.yazici.footballsimulationapi.mapper;

import com.yazici.footballsimulationapi.dto.request.CreateMatchRequest;
import com.yazici.footballsimulationapi.dto.response.CreateMatchResponse;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MatchMapperImpl", componentModel = "spring")
public interface IMatchMapper {
    CreateMatchResponse toResponse(CreateMatchRequest request);
}
