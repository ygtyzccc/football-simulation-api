package com.yazici.footballsimulationapi.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GoalMinuteRecord {

    @Id @GeneratedValue private Long id;

    @Column(name = "goal_minute")
    private int goalMinute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private Match match;

    @Override
    public String toString(){
        return String.format("%d - %s", goalMinute, player);
    }
}
