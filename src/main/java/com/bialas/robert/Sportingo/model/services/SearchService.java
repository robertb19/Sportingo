package com.bialas.robert.Sportingo.model.services;

import com.bialas.robert.Sportingo.model.entities.Location;
import com.bialas.robert.Sportingo.model.entities.Search;
import com.bialas.robert.Sportingo.model.sports.Sports;
import com.bialas.robert.Sportingo.model.forms.LocationForm;
import com.bialas.robert.Sportingo.model.repositories.LocationRepository;
import com.bialas.robert.Sportingo.model.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value="session")
public class SearchService {

    @Autowired
    private UserService userService;
    @Autowired
    SearchRepository searchRepository;
    @Autowired
    LocationRepository locationRepository;

    public Location setLocation(LocationForm locationForm){

        Location location = new Location();
        location.setDistrict(locationForm.getDistrict());
        location.setHouseNumber(locationForm.getHouseNumber());
        location.setStreetName(locationForm.getStreetName());

        try {
            locationRepository.save(location);
        } catch (Exception e){
            e.printStackTrace();
        }

        return location;
    }

    public Sports setSports(LocationForm locationForm){

        Sports chosenSport = new Sports();
        chosenSport.setSport(locationForm.getSports());
        return chosenSport;

    }

    public void beginSearch(LocationForm locationForm){

        Location location = setLocation(locationForm);
        Sports chosenSport = setSports(locationForm);


        Search search = new Search();
        search.setLocation(location);
        search.setSport(chosenSport.toString());
        search.setUserEntity(userService.getUserData());

        try {
            searchRepository.save(search);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
