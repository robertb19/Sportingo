package com.bialas.robert.Sportingo.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="location")
@Data
public class Location {

    @Id
    @GeneratedValue
    @Column(name="locationid")
    private int id;
    //String coordianates;
    private String district;
    @Column(name="street_name")
    private String streetName;
    @Column(name="house_number")
    private int houseNumber;

}
