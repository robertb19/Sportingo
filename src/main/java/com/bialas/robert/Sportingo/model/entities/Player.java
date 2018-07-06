package com.bialas.robert.Sportingo.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="player")
@Data
public class Player {

    @Id
    @GeneratedValue
    int playerid;
    @OneToOne
    @JoinColumn(name = "userid")
    UserEntity userEntity;
    @Column(name="rank_level")
    int rankLevel;
    @OneToOne
    @JoinColumn(name = "locationid")
    Location location;
    @Column(name ="user_status")
    String userStatus = "NOT_SEARCHING";

}

