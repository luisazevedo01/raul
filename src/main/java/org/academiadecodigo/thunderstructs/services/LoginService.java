package org.academiadecodigo.thunderstructs.services;


import org.academiadecodigo.thunderstructs.models.User;

public interface LoginService {

    User authentication(String username, String password);

}
