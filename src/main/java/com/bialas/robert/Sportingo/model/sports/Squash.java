package com.bialas.robert.Sportingo.model.sports;

import com.bialas.robert.Sportingo.model.entities.Player;
import lombok.Data;

@Data
public class Squash implements Sport{

    private String level;
    private Player playerOne;
    private Player playerTwo;

}
