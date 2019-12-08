package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Player;

import java.util.List;

public interface TournamentService {

    void init (List<Player> players);

    boolean checkGroupWinners ();

    void generateFinal ();

    java.util.List<Player> getWinnersList();

}
