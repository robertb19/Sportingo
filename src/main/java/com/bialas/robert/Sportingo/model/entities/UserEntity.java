package com.bialas.robert.Sportingo.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private int userid;
    String login;
    String password;
    @Column(name ="has_admin")
    boolean hasAdmin;

}
