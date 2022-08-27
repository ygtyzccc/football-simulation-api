package com.yazici.footballsimulationapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue private Long id;

    @Column(nullable = false, name = "name")
    private String teamName;

    @Column( name = "team_code_name", nullable = false, unique = true)
    private String teamCodeName;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Player> players;

    @OneToMany(mappedBy = "home")
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "away")
    private List<Match> awayMatches;

    @Override
    public String toString(){

        return teamCodeName;
    }
}