package org.academiadecodigo.thunderstructs.utility;

import org.academiadecodigo.thunderstructs.models.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {

        return o2.getScore() - o1.getScore();
    }
}
