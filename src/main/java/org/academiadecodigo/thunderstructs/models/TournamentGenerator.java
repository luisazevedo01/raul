package org.academiadecodigo.thunderstructs.models;

import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.models.Team;
import org.academiadecodigo.thunderstructs.models.Tournament;
import org.academiadecodigo.thunderstructs.services.MockGroupService;

import java.util.LinkedList;
import java.util.List;

public class TournamentGenerator {

    public static Tournament populate () {

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        team1.setName("JudasFriends F.C.");
        team2.setName("Traitors F.C.");
        team3.setName("Cross F.C.");
        team4.setName("Heaven F.C.");


        player1.setName("Barrabás");
        player2.setName("Judas");
        player3.setName("Cristo");
        player4.setName("Espírito Santo");

        player1.setTeam(team1);
        player2.setTeam(team2);
        player3.setTeam(team3);
        player4.setTeam(team4);

        List<Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);

        MockGroupService mockGroupService = new MockGroupService();
        mockGroupService.generateGroups(list);

        Tournament tournament = new Tournament();
        tournament.setId(1);
        tournament.setPlayers(list);
        tournament.setGroups(mockGroupService.getGroupList());
        return tournament;
    }

}
