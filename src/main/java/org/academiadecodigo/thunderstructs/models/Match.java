package org.academiadecodigo.thunderstructs.models;

public class Match {

    private Player p1;
    private Player p2;
    private int p1Goals;
    private int p2Goals;


    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public int getP1Goals() {
        return p1Goals;
    }

    public void setP1Goals(int p1Goals) {
        this.p1Goals = p1Goals;
    }

    public int getP2Goals() {
        return p2Goals;
    }

    public void setP2Goals(int p2Goals) {
        this.p2Goals = p2Goals;
    }
}
