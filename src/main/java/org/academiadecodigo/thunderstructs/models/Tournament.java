package org.academiadecodigo.thunderstructs.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Tournament {


    private int id;
    private String name;
    private List<Player> players;
    private List<Group> groups;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}


