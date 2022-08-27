package com.yazici.footballsimulationapi.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class PlayerAttributes {

    @Id @GeneratedValue private Long id;
    private int attack;
    private int defence;
    @Column(name = "keeping_att")
    private int keepingAtt;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

}
