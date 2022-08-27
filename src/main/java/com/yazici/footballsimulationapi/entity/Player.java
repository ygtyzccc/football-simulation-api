package com.yazici.footballsimulationapi.entity;

import com.yazici.footballsimulationapi.entity.enums.PlayerPosition;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Player {

    @Id @GeneratedValue private Long id;
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private PlayerPosition position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @ToString.Exclude
    private Team team;

    @OneToOne(mappedBy = "player")
    private PlayerAttributes playerAttributes;

    @OneToMany(mappedBy = "player")
    @ToString.Exclude
    private List<GoalMinuteRecord> matchStatistics;

    @Override
    public String toString(){

        return String.format("%s %s", firstName, lastName);

    }
}
