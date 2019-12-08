package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Tournament;
import org.springframework.stereotype.Service;

@Service
public class MockTournamentService implements TournamentService {


    private Tournament tournament;


    @Override
    public boolean checkGroupWinners() {

        boolean winners = true;

        for (Group g: tournament.getGroups()) {



        }
        return false;
    }

    @Override
    public void generateFinal() {

    }
}
