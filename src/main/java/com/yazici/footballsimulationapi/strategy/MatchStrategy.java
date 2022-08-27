package com.yazici.footballsimulationapi.strategy;

import com.yazici.footballsimulationapi.entity.Match;
import com.yazici.footballsimulationapi.entity.Player;
import com.yazici.footballsimulationapi.entity.Team;
import com.yazici.footballsimulationapi.entity.enums.PlayerPosition;
import com.yazici.footballsimulationapi.strategy.dto.GoalMinuteStrategyDto;
import lombok.Getter;

import java.util.*;

@Getter
public class MatchStrategy {
    private static final int MINUTES_INTERVAL = 5;
    private static final int MATCH_MINUTE = 90;
    private static final int INTERVAL_COUNT = MATCH_MINUTE / MINUTES_INTERVAL;
    private static final Random R = new Random();
    private final Team homeTeam;
    private final Team awayTeam;
    private int homeKeeperAttribute;
    private int homeTeamDefence;
    private int homeTeamAttack;
    private int awayKeeperAttribute;
    private int awayTeamDefence;
    private int awayTeamAttack;
    private int homeScore;
    private int awayScore;
    private final List<GoalMinuteStrategyDto> goalMinuteStrategyDtoList = new ArrayList<>();

    public MatchStrategy(Match match) {
        this.homeTeam = match.getHome();
        this.awayTeam = match.getAway();
        this.calculateHomeTeamAttributes();
        this.calculateAwayTeamAttributes();
        this.setKeepersAttributes();
    }

    public void playMatch(){
        for (int i = 0; i < INTERVAL_COUNT; ++i) {
            int minute = i * MINUTES_INTERVAL + R.nextInt(MINUTES_INTERVAL);
            this.goalChanceForHome(minute);
            this.goalChanceForAway(minute);
        }

    }

    private void setKeepersAttributes(){
        homeTeam.getPlayers().stream()
                .filter(player -> player.getPosition() == PlayerPosition.KEEPER)
                .findFirst().ifPresentOrElse(
                        player -> homeKeeperAttribute = player.getPlayerAttributes().getKeepingAtt(),
                        () -> homeKeeperAttribute = 0);

        awayTeam.getPlayers().stream()
                .filter(player -> player.getPosition() == PlayerPosition.KEEPER)
                .findFirst().ifPresentOrElse(
                        player ->awayKeeperAttribute = player.getPlayerAttributes().getKeepingAtt(),
                        () -> awayKeeperAttribute = 0);
    }

    private void calculateHomeTeamAttributes() {
        homeTeamDefence = homeTeam.getPlayers().stream()
                .mapToInt(player -> player.getPlayerAttributes().getDefence()).sum();

        homeTeamAttack = homeTeam.getPlayers().stream()
                .mapToInt(player -> player.getPlayerAttributes().getAttack()).sum();
    }

    private void calculateAwayTeamAttributes() {
        awayTeamDefence = awayTeam.getPlayers().stream()
                .mapToInt(player -> player.getPlayerAttributes().getDefence()).sum();

        awayTeamAttack = awayTeam.getPlayers().stream()
                .mapToInt(player -> player.getPlayerAttributes().getAttack()).sum();
    }

    private static boolean isGoal(int attack, int defence, int keepingAtt){
        int keeperFactor = keepingAtt / 20;
        int randomFormForPositionAttack = R.nextInt(150) - 50;
        int randomFormForPositionDefence = R.nextInt(150) - 50;

        if ((attack + randomFormForPositionAttack) - (defence + randomFormForPositionDefence) > 0) {
            int randomNumber = R.nextInt(keeperFactor);
            if (randomNumber == 0)
                return true;
        }
        return false;
    }

    private int goalChance(int attack, int defence, int keepingAtt,
                                  int attackSideScore, int minute, Team team)
    {
        if (isGoal(attack, defence, keepingAtt)){
            var goalMinute = new GoalMinuteStrategyDto();
            goalMinute.setMinute(minute);
            goalMinute.setPlayer(findWhoScoreTheGoal(team.getPlayers()));
            goalMinuteStrategyDtoList.add(goalMinute);

            return ++attackSideScore;
        }
        return attackSideScore;
    }

    private void goalChanceForHome(int minute){
        homeScore = this.goalChance(homeTeamAttack, awayTeamDefence, homeKeeperAttribute,
                homeScore, minute, homeTeam);

    }

    private void goalChanceForAway(int minute){
        awayScore = this.goalChance(awayTeamAttack, awayTeamDefence, awayKeeperAttribute,
                awayScore, minute, awayTeam);

    }

    public static Player findWhoScoreTheGoal(List<Player> players){

        TreeSet<Player> possibleScorers =
                new TreeSet<>((p1, p2) -> p2.getPlayerAttributes().getAttack() - p1.getPlayerAttributes().getAttack());

        while (possibleScorers.size() < 3){
            possibleScorers.add(players.get(R.nextInt(10) + 1));
        }

        return possibleScorers.first();

    }
}