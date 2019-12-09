package org.academiadecodigo.thunderstructs.models;

import org.springframework.stereotype.Component;

@Component
public class Player {

    private String name;
    private Teams team;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", team=" + team +
                ", score=" + score +
                '}';
    }
}
