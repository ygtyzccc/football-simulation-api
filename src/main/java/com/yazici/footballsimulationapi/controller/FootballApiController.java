package com.yazici.footballsimulationapi.controller;

import com.yazici.footballsimulationapi.dto.request.*;
import com.yazici.footballsimulationapi.dto.response.*;
import com.yazici.footballsimulationapi.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Football simulation api documentation")
@RequestMapping("/football-api")
@RequiredArgsConstructor
public class FootballApiController {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final LeagueService leagueService;
    private final PlayerAttributeService playerAttributeService;
    private final MatchService matchService;

    @PostMapping("player/save")
    @ApiOperation("Add new player")
    public CreatePlayerResponse savePlayer(@RequestBody CreatePlayerRequest request){

        return playerService.save(request);
    }

    @PostMapping("team/save")
    @ApiOperation("Add new team")

    public CreateTeamResponse saveTeam(@RequestBody CreateTeamRequest request){

        return teamService.save(request);
    }

    @PostMapping("league/save")
    @ApiOperation("Add new league")
    public CreateLeagueResponse saveLeague(@RequestBody CreateLeagueRequest request){

        return leagueService.save(request);
    }

    @PostMapping("playerAtt/save")
    @ApiOperation("Add player attribute")
    public CreatePlayerAttributesResponse savePlayerAtt(@RequestBody CreatePlayerAttributesRequest request){

        return playerAttributeService.savePlayerAtt(request);
    }

    @GetMapping("match/get")
    @ApiOperation("Get match records")
    public QueryMatchResponse getMatchRecords(@RequestParam Long id){

        return matchService.getAllMatchRecordsByMatchId(id);
    }

    @PostMapping("match/save")
    @ApiOperation("Add new match")
    public CreateMatchResponse saveMatch(@RequestBody CreateMatchRequest request){
        return matchService.saveMatch(request);
    }

    @PostMapping("match/play")
    @ApiOperation("Play the given match")
    public PlayMatchResponse playMatch(@RequestBody PlayMatchRequest request){
        return matchService.playMatch(request);
    }

}
