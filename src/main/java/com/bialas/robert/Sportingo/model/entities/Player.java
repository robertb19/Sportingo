package com.bialas.robert.Sportingo.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Player {

    @Id
    @GeneratedValue
    private int playerid;
    @OneToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;
    @Column(name="rank_level")
    private int rankLevel = 0;
    @Column
    private boolean searching = false;
    @Column
    private String name;
    @Column
    private String city;


}

