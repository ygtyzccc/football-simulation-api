package com.yazici.footballsimulationapi.mapper;

import com.yazici.footballsimulationapi.dto.request.CreateLeagueRequest;
import com.yazici.footballsimulationapi.dto.response.CreateLeagueResponse;
import com.yazici.footballsimulationapi.entity.League;
import org.mapstruct.Mapper;

@Mapper(implementationName = "LeagueMapperImpl", componentModel = "spring")
public interface ILeagueMapper {
    League toLeague(CreateLeagueRequest request);
    CreateLeagueResponse toResponse(League league);
}
