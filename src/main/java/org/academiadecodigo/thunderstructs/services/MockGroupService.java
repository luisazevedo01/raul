package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Group;
import org.academiadecodigo.thunderstructs.models.Match;
import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.utility.PlayerComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MockGroupService implements GroupService {


    private List<Group> groups;
    private MatchService mockMatchService;

    @Override
    public List<Group> generateGroups(List<Player> players) {

        groups = new LinkedList<>();
        Group groupA = new Group(1);
        groupA.setName("Group A");
        Group groupB = new Group(2);
        groupB.setName("Group B");

        for (Player player : players) {
            if (players.indexOf(player) < (players.size() / 2)) {
                groupA.getPlayers().add(player);
            } else {
                groupB.getPlayers().add(player);
            }
        }
        groups.add(groupA);
        groups.add(groupB);
        return groups;
    }


    @Autowired
    public void setMockMatchService(MockMatchService mockMatchService) {
        this.mockMatchService= mockMatchService;
    }

    @Override
    public List<Match> generateMatches( int groupId) {
        List<Match> matches = mockMatchService.generateMatches(getGroup(groupId).getPlayers());
        groups.get(groupId - 1).setMatches(matches);
        return matches;
    }

    @Override
    public Group getGroup(Integer id) {
        return getGroupList().get(id - 1);
    }

    @Override
    public List<Group> getGroupList() {
        return groups;
    }

    @Override
    public List<Player> sortPlayers(Group group) {
        group.getPlayers().sort(new PlayerComparator());
        return group.getPlayers();
    }

    @Override
    public List<Match> getMatches( Group group) {
        return group.getMatches();
    }

    @Override
    public List<Player> getGroupPlayers(int id) {

        return groups.get(id - 1).getPlayers();
    }


}
