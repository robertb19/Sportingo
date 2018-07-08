package com.bialas.robert.Sportingo.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="search")
public class Search {

    @Id
    @GeneratedValue
    @Column(name="searchid")
    int id;
    @OneToOne
    @JoinColumn(name = "player1id")
    Player player1;
    @OneToOne
    @JoinColumn(name = "player2id")
    Player player2;
    /*@Transient
    Sport sportChosen;*/
    @Column(name="sport")
    String sport;
    @OneToOne
    @JoinColumn(name = "locationid")
    Location location;

}
