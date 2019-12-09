package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Match;
import org.academiadecodigo.thunderstructs.models.Player;

import java.util.List;

public interface MatchService {

    Match add(Match match);

    Match get(Integer id);

    void update(Integer id, Match match);

    void delete(Match match);

    List<Match> list(Integer groupId);

    void getResult(Match match);

    List<Match> generateMatches(List<Player> playerList);
}
