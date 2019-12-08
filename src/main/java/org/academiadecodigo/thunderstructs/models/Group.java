package org.academiadecodigo.thunderstructs.models;

import java.util.LinkedList;
import java.util.List;

public class Group {

    private Integer id;
    private String name;
    private List<Player> players;
    private List<Match> matches;
    private Player winner;

    public Group(Integer id) {
        this.id = id;
        players = new LinkedList<>();
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", winner=" + winner +
                '}';
    }
}
