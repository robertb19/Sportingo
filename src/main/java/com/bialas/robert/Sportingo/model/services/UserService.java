package com.bialas.robert.Sportingo.model.services;

import com.bialas.robert.Sportingo.model.entities.UserEntity;
import com.bialas.robert.Sportingo.model.forms.LoginForm;
import com.bialas.robert.Sportingo.model.forms.RegistrationForm;
import com.bialas.robert.Sportingo.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value="session")

public class UserService{

    @Autowired
    UserRepository userRepository;
    private boolean isLoggedIn;
    private UserEntity userData;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public UserEntity getUserData() {
        return userData;
    }

    public void setUserData(UserEntity userData) {
        this.userData = userData;
    }

    public boolean doesUserExistByLogin(String login){
        return userRepository.existsByLogin(login);
    }

    public boolean registerUser(RegistrationForm registrationForm){

    try {

        UserEntity newUser = new UserEntity();
        newUser.setHasAdmin(false);
        newUser.setLogin(registrationForm.getLogin());
        newUser.setPassword(registrationForm.getPassword());

        userRepository.save(newUser);
    }

    catch (Exception e){
        e.printStackTrace();
        return false;
    }

        return true;
    }

    public boolean loginUser(LoginForm loginForm){
        Optional<UserEntity> userEntity = userRepository.findByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword());
        if(userEntity.isPresent()) this.setLoggedIn(true);
        setUserData(userEntity.get());
        return userEntity.isPresent();
    }



}
