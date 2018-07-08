package com.bialas.robert.Sportingo.model.services;

import com.bialas.robert.Sportingo.model.entities.Player;
import com.bialas.robert.Sportingo.model.forms.PlayerForm;
import com.bialas.robert.Sportingo.model.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value="session")
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private UserService userService;

    private Player player;

    public Player getPlayerData(){
        return player;
    }

    public void createPlayer(PlayerForm playerForm){

     try {
         player = new Player();
         player.setName(playerForm.getName());
         player.setCity(playerForm.getCity());
         player.setUserEntity(userService.getUserData());

         playerRepository.save(player);
        }
        catch (Exception e){
         e.printStackTrace();
     }

    }

    public void updatePlayerName(String name, PlayerForm playerForm){
        //to implement
    }

    public void updatePlayercity(String city, PlayerForm playerForm){
        //to implement
    }

    public List<Player> getAllSearching(){
        return playerRepository.findPlayersBySearching(true);
    }


}
