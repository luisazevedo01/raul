package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Match;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MockMatchService implements MatchService {

    private List<Match> matches;


    public MockMatchService() {
        this.matches = new LinkedList<>();

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
}
