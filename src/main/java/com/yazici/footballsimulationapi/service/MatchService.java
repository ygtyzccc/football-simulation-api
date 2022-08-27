package com.yazici.footballsimulationapi.service;

import com.yazici.footballsimulationapi.constant.error.MatchError;
import com.yazici.footballsimulationapi.dto.GoalMinuteDto;
import com.yazici.footballsimulationapi.dto.request.CreateMatchRequest;
import com.yazici.footballsimulationapi.dto.request.PlayMatchRequest;
import com.yazici.footballsimulationapi.dto.response.CreateMatchResponse;
import com.yazici.footballsimulationapi.dto.response.PlayMatchResponse;
import com.yazici.footballsimulationapi.dto.response.QueryMatchResponse;
import com.yazici.footballsimulationapi.entity.GoalMinuteRecord;
import com.yazici.footballsimulationapi.entity.Match;
import com.yazici.footballsimulationapi.exception.MatchException;
import com.yazici.footballsimulationapi.mapper.IMatchMapper;
import com.yazici.footballsimulationapi.repository.IGoalMinuteRecordRepository;
import com.yazici.footballsimulationapi.repository.IMatchRepository;
import com.yazici.footballsimulationapi.strategy.MatchStrategy;
import com.yazici.footballsimulationapi.strategy.dto.GoalMinuteStrategyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final IGoalMinuteRecordRepository goalMinuteRecordRepository;
    private final IMatchRepository matchRepository;
    private final TeamService teamService;
    private final IMatchMapper matchMapper;

    public Match getMatchById(Long id){

        return matchRepository.findById(id).orElseThrow(() -> new MatchException(MatchError.NOT_FOUND));

    }

    public QueryMatchResponse getAllMatchRecordsByMatchId(Long id){

        var match = getMatchById(id);

        var goalMinutesList = match.getGoalMinuteRecords();
        var goalMinuteDtoList = setGoalMinuteDtoRecordFromList(goalMinutesList);

        return QueryMatchResponse.builder()
                .homeTeamName(match.getHome().getTeamName())
                .homeTeamScore(match.getHomeTeamScore())
                .awayTeamName(match.getAway().getTeamName())
                .awayTeamScore(match.getAwayTeamScore())
                .goalMinuteScorerList(goalMinuteDtoList)
                .build();

    }

    public CreateMatchResponse saveMatch(CreateMatchRequest request){
        var homeTeam = teamService.getTeamByTeamCodeName(request.getHomeTeamCodeName());
        var awayTeam = teamService.getTeamByTeamCodeName(request.getAwayTeamCodeName());

        var match = Match.builder()
                .home(homeTeam)
                .away(awayTeam).build();

        matchRepository.save(match);
        var response = matchMapper.toResponse(request);
        response.setMatchDateTime(match.getMatchDateTime());

        return response;
    }

    public PlayMatchResponse playMatch(PlayMatchRequest playMatchRequest){

        var match = getMatchById(playMatchRequest.getMatchId());

        if (match.isPlayed())
            throw new MatchException(MatchError.MATCH_ALREADY_PLAYED);

        var matchStrategy = new MatchStrategy(match);
        matchStrategy.playMatch();
        var goalScorerMinuteList = setGoalMinuteRecordFromList(matchStrategy.getGoalMinuteStrategyDtoList(), match);

        match.setHomeTeamScore(matchStrategy.getHomeScore());
        match.setAwayTeamScore(matchStrategy.getAwayScore());
        match.setGoalMinuteRecords(goalScorerMinuteList);
        match.setPlayed(true);

        goalMinuteRecordRepository.saveAll(goalScorerMinuteList);
        matchRepository.save(match);

        return PlayMatchResponse.builder()
                .homeTeamCodeName(match.getHome().getTeamCodeName())
                .awayTeamCodeName(match.getAway().getTeamCodeName())
                .homeTeamScore(matchStrategy.getHomeScore())
                .awayTeamScore(matchStrategy.getAwayScore())
                .matchDateTime(match.getMatchDateTime())
                .build();


    }

    private List<GoalMinuteRecord> setGoalMinuteRecordFromList(List<GoalMinuteStrategyDto> goalMinuteStrategyDtoList, Match match){

        return goalMinuteStrategyDtoList.stream()
                .map(dto -> GoalMinuteRecord.builder()
                        .goalMinute(dto.getMinute())
                        .match(match)
                        .player(dto.getPlayer())
                        .build()).collect(Collectors.toList());

    }

    private List<GoalMinuteDto> setGoalMinuteDtoRecordFromList(List<GoalMinuteRecord> goalMinuteRecordList){

        return goalMinuteRecordList.stream()
                .map(goalrecord -> GoalMinuteDto.builder()
                        .minute(goalrecord.getGoalMinute())
                        .playerFullName(goalrecord.getPlayer().getFirstName() + " " + goalrecord.getPlayer().getLastName())
                        .build()).collect(Collectors.toList());
    }

}
