package com.bialas.robert.Sportingo.model.sports;

import com.bialas.robert.Sportingo.model.entities.Player;
import com.bialas.robert.Sportingo.model.sports.Sport;
import lombok.Data;

@Data
public class Running implements Sport{

    Player playerOne;
    Player playerTwo;
    double distance;

}
