package com.bialas.robert.Sportingo.model.forms;
import com.bialas.robert.Sportingo.model.sports.SportsList;
import com.bialas.robert.Sportingo.model.sports.Sports;
import lombok.Data;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Data
public class LocationForm {

    String district;
    String streetName;
    int houseNumber;
    String sports;

    public static List<String> getAllSports(){
        EnumSet enumSet = EnumSet.allOf(SportsList.class);
        List<String> theSports = new ArrayList<>();

        for(Object o : enumSet){
            theSports.add(o.toString());
        }

        return theSports;
    }
}
