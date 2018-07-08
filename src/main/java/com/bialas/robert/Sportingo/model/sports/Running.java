package com.bialas.robert.Sportingo.model.sports;

import com.bialas.robert.Sportingo.model.entities.Player;
import com.bialas.robert.Sportingo.model.sports.Sport;
import lombok.Data;

@Data
public class Running implements Sport{

    private Player playerOne;
    private Player playerTwo;
    private double distance;

}
