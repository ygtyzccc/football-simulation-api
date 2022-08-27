package com.yazici.footballsimulationapi.mapper;

import com.yazici.footballsimulationapi.dto.request.CreateTeamRequest;
import com.yazici.footballsimulationapi.dto.response.CreateTeamResponse;
import com.yazici.footballsimulationapi.entity.Team;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TeamMapperImpl", componentModel = "spring")
public interface ITeamMapper {
    Team toTeam(CreateTeamRequest request);
    CreateTeamResponse toResponse(Team team);

}
