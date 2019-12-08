package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Player;

import java.util.List;

public interface TournamentService {

    boolean checkGroupWinners ();

    void generateFinal ();

    java.util.List<Player> getWinnersList();

    List<Player> getPlayers();

}
