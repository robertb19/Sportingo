package com.bialas.robert.Sportingo.controller;

import com.bialas.robert.Sportingo.model.entities.Player;
import com.bialas.robert.Sportingo.model.forms.PlayerForm;
import com.bialas.robert.Sportingo.model.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/player")
    public String playerScreen(Model model){
        model.addAttribute("playerForm", new PlayerForm());
        return "/player";
    }

    @PostMapping("/player")
    public String updatePlayerProfile(@ModelAttribute PlayerForm playerForm){
        if(playerForm.getCity() != null && playerForm.getName() != null) {
            playerService.createPlayer(playerForm);
            return "redirect:/welcome";
        }

        else{
            return "/player";
        }
    }


}
