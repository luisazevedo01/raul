package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Group;
import org.academiadecodigo.thunderstructs.models.Match;
import org.academiadecodigo.thunderstructs.models.Player;
import java.util.List;

public interface GroupService {


    List<Group> generateGroups(List<Player> players);

    List<Group> getGroupList();

    List<Player> sortPlayers(Group group);

    Group getGroup(Integer id);

    List<Match> getMatches(Group group);

    List<Player> getGroupPlayers(int id);


}
