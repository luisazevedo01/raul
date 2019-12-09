package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.App;
import org.academiadecodigo.thunderstructs.models.Group;
import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.models.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class MockTournamentService implements TournamentService {


    private Tournament tournament;
    private App app;

    @Override
    public boolean checkGroupWinners() {

        for (Group g: tournament.getGroups()) {

            if (g.getWinner() == null) {

                return false;

            }

        }
        return true;
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

    @Override
    public List<Group> getGroups() {
        return tournament.getGroups();
    }

    @Override
    public Tournament getTournament(int id) {

        return app.getTournamentList().get(id - 1);
    }

    @Autowired
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Autowired
    public void setApp(App app) {
        this.app = app;
    }
}
