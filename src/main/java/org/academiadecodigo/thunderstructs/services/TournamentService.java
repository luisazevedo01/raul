package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Group;
import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.models.Tournament;

import java.util.List;

public interface TournamentService {

    boolean checkGroupWinners ();

    void generateFinal ();

    java.util.List<Player> getWinnersList();

    List<Player> getPlayers();

    List<Group> getGroups ();

    Tournament getTournament(int id);

}
