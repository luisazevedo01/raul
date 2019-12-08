package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Group;
import org.academiadecodigo.thunderstructs.models.Match;
import org.academiadecodigo.thunderstructs.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MockMatchService implements MatchService {


    private MockGroupService mockGroupService;
    private List<Match> matches;


    public MockMatchService() {

    }

    @Autowired
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @Autowired
    public void setMockGroupService(MockGroupService mockGroupService) {
        this.mockGroupService = mockGroupService;
    }

    @Override
    public Match add(Match match) {
        matches.add(match);

        return match;
    }

    @Override
    public Match get(Integer id) {

        return matches.get(id);
    }

    @Override
    public void update(Integer id, Match match) {

        matches.set(id, match);
    }

    @Override
    public void delete(Match match) {

        matches.remove(match);

    }

    @Override
    public List<Match> list(Integer groupId) {

        for (Match match : matches) {
            if (match.getGroup().getId() == groupId) {
                matches.add(match);
            }
        }
        return matches;
    }

    @Override
    public void getResult(Match match) {

        if (match.getP1Goals() < match.getP2Goals()) {
            match.getP2().setScore(match.getP2().getScore() + 3);
            return;

        } else if (match.getP1Goals() > match.getP2Goals()) {
            match.getP1().setScore(match.getP2().getScore() + 3);
            return;
        }

        match.getP1().setScore(match.getP1().getScore() + 1);
        match.getP2().setScore(match.getP2().getScore() + 1);

    }

    @Override
    public List<Match> generateMatches(List<Player> playerList) {

        List<Match> matches = new LinkedList<>();

        for (int i = 0; i < playerList.size() - 1; i++) {

            for (int j = i + 1; j < playerList.size(); j++) {

                matches.add(new Match(playerList.get(i), playerList.get(j)));

            }
        }
        return matches;
    }

}

