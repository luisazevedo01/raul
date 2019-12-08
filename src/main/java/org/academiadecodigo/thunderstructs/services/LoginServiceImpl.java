package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.App;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {


    private App app;
    private boolean authenticate = false;
    private User loggedUser;


    @Autowired
    public void setApp(App app) {
        this.app = app;
    }

    public User authentication(String username, String password) {
        List<User> users = app.getUsers();

        for (User user : users) {

            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authenticate = true;
                loggedUser = user;
                return loggedUser;

            }
        }
        loggedUser = null;
        return loggedUser;
    }

    public boolean isAuthenticate() {
        return authenticate;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
