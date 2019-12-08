package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Group;
import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.models.Tournament;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class MockTournamentService implements TournamentService {


    private Tournament tournament;

    @Override
    public boolean checkGroupWinners() {

        boolean winners = true;

        for (Group g: tournament.getGroups()) {

            if (g.getWinner() == null) {

                winners = false;

            }

        }
        return winners;
    }

    @Override
    public void generateFinal() {

        if (checkGroupWinners()) {

            getWinnersList();

        }
    }

    @Override
    public List<Player> getWinnersList() {

        List<Player> winners = new LinkedList<>();

        for (Group g : tournament.getGroups()) {

            winners.add(g.getWinner());

        }
        return winners;
    }

    @Override
    public List<Player> getPlayers() {
        return tournament.getPlayers();
    }
}
