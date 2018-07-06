package com.bialas.robert.Sportingo.controller;

import com.bialas.robert.Sportingo.model.forms.LocationForm;
import com.bialas.robert.Sportingo.model.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping
    public String search(Model model){

        model.addAttribute("locationForm", new LocationForm());

        return "/welcome";

    }

    @PostMapping
    public String search(Model model, @ModelAttribute LocationForm locationForm){
        searchService.beginSearch(locationForm);
        return "/welcome";
    }

}

