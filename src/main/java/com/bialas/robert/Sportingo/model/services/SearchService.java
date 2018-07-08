package com.bialas.robert.Sportingo.model.services;

import com.bialas.robert.Sportingo.model.DBOperations;
import com.bialas.robert.Sportingo.model.entities.Location;
import com.bialas.robert.Sportingo.model.entities.Player;
import com.bialas.robert.Sportingo.model.entities.Search;
import com.bialas.robert.Sportingo.model.repositories.PlayerRepository;
import com.bialas.robert.Sportingo.model.sports.Sports;
import com.bialas.robert.Sportingo.model.forms.LocationForm;
import com.bialas.robert.Sportingo.model.repositories.LocationRepository;
import com.bialas.robert.Sportingo.model.repositories.SearchRepository;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*

This method will be working completely different, application architecture structure change lead to change
of thinking. Instead of adding a new search it will add two searching players to the same basket in a thread if it finds one.
Will work on next after completing player profile classes.

 */

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value="session")
public class SearchService {

    @Autowired
    SearchRepository searchRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    PlayerService playerService;
    private static SessionFactory factory;

    private Location location;
    private Sports chosenSport;
    String searchText = "Not searching yet";

    public String getSearchText(){
        return searchText;
    }

    public void changeSearchTextToSearching(){
        searchText = "Searching...";
    }


    public void setLocation(LocationForm locationForm){

        location = new Location();

        location.setDistrict(locationForm.getDistrict());
        location.setHouseNumber(locationForm.getHouseNumber());
        location.setStreetName(locationForm.getStreetName());

        try {
            locationRepository.save(location);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setSports(LocationForm locationForm){

        chosenSport = new Sports();
        chosenSport.setSport(locationForm.getSports());

    }

    public void beginSearch(LocationForm locationForm){

        setSports(locationForm);
        setLocation(locationForm);
        makePlayerSearching();

    }

    public void createSearch(){

        List<Player> pairedPlayers = pairPlayers();

        if(isPaired(pairedPlayers)){
            Search search = new Search();
            search.setLocation(location);
            search.setSport(chosenSport.toString());
            search.setPlayer1(pairedPlayers.get(0));
            search.setPlayer2(pairedPlayers.get(1));
            searchRepository.save(search);
        }
    }

    public boolean isPaired(List<Player> mappedPlayers){
        if(mappedPlayers.size() > 1){
            return true;
        }
        else return false;
    }

    public void makePlayerSearching(){

        Optional<Player> optionalPlayer = playerRepository.findByPlayerid(playerService.getPlayerData().getPlayerid());
        if(optionalPlayer.isPresent()){
            Player player = optionalPlayer.get();
            player.setSearching(true);
            playerRepository.save(player);
        }
    }

    public List<Player> pairPlayers(){
        List<Player> pairedPlayers = new ArrayList<>();
        List<Player> searchingPlayerList = playerService.getAllSearching();

        if(searchingPlayerList.size() > 0) {
            for (Player p : searchingPlayerList) {
                if (p.getPlayerid() != playerService.getPlayerData().getPlayerid()){
                    pairedPlayers.add(p);
                    pairedPlayers.add(playerService.getPlayerData());
                    return pairedPlayers;
                }
            }
        }

        return pairedPlayers;
    }


}
