package com.bialas.robert.Sportingo.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Player {

    @Id
    @GeneratedValue
    int playerid;
    @OneToOne
    @JoinColumn(name = "userid")
    UserEntity userEntity;
    @Column(name="rank_level")
    int rankLevel = 0;
    @Column
    boolean searching = false;
    @Column
    String name;
    @Column
    String city;


}

