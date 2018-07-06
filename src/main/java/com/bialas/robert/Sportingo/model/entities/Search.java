package com.bialas.robert.Sportingo.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="search")
public class Search {

    @Id
    @GeneratedValue
    @Column(name="searchid")
    int id;
    @OneToOne
    @JoinColumn(name = "userid")
    UserEntity userEntity;
    /*@Transient
    Sport sportChosen;*/
    @Column(name="sport")
    String sport;
    @OneToOne
    @JoinColumn(name = "locationid")
    Location location;

}
