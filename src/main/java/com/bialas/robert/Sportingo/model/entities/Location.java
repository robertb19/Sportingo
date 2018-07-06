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
    int id;
    //String coordianates;
    String district;
    @Column(name="street_name")
    String streetName;
    @Column(name="house_number")
    int houseNumber;

}
