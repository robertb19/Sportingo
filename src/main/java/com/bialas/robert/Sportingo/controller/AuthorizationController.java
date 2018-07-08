package com.bialas.robert.Sportingo.controller;

import com.bialas.robert.Sportingo.model.forms.LoginForm;
import com.bialas.robert.Sportingo.model.forms.RegistrationForm;
import com.bialas.robert.Sportingo.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthorizationController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, Model model){
        if(userService.doesUserExistByLogin(loginForm.getLogin())){
            if(userService.loginUser(loginForm))
            return "redirect:/player";
        }
        model.addAttribute("information", "Error, the login or password is incorrect! Please try again");
        return "/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegistrationForm registrationForm, Model model){

        if(userService.doesUserExistByLogin(registrationForm.getLogin())== false){
            if(userService.registerUser(registrationForm)) return "redirect:/login";
        }
        else {
            model.addAttribute("information", "This login is already taken! Please choose another one.");
            return "/register";
        }
        return "redirect:/register?fail";
    }
}
