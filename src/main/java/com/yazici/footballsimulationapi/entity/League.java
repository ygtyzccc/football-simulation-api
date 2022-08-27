package com.yazici.footballsimulationapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "league")
public class League {
    @Id @GeneratedValue private Long id;

    @Column(name = "name", nullable = false)
    private String leagueName;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Team> teams;
}