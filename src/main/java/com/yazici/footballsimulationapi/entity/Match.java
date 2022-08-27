package com.yazici.footballsimulationapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "match_records")
public class Match {

    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id")
    private Team home;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id")
    private Team away;

    @Column(name = "home_team_score")
    private Integer homeTeamScore;

    @Column(name = "away_team_score")
    private Integer awayTeamScore;

    @Column(name = "match_date_time")
    private LocalDateTime matchDateTime;

    @Column(name = "is_played")
    private boolean isPlayed;

    @OneToMany(mappedBy = "match")
    private List<GoalMinuteRecord> goalMinuteRecords;

    @PrePersist
    private void onCreate(){
        this.matchDateTime = LocalDateTime.now();
    }

    @Override
    public String toString(){

        return String.format("%s - %s", home, away);
    }

}
