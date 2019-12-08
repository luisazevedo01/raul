package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.App;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    private App app;


    @Autowired
    public void setApp(App app) {
        this.app = app;
    }

    public boolean saveUser(User user){
        if(userExists(user)){
            return false;
        }
        app.getUsers().add(user);
        return true;

    }

    public User getUser(String username){
        for(User u : app.getUsers()){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }

    private boolean userExists(User user){

       for(User u : app.getUsers()){
           if(u.getUsername().equals(user.getUsername())){
               return true;
           }
       }
       return false;
    }



}
