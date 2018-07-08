package com.bialas.robert.Sportingo.model.sports;

import lombok.Data;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Data
public class Sports {

    private String sport;

    public static List<String> returnSports(){

        EnumSet enumSet = EnumSet.allOf(SportsList.class);
        List<String> theSports = new ArrayList<>();

        for(Object o : enumSet){
            theSports.add(o.toString());
        }

        return theSports;
    }

}
