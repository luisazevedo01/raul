package org.academiadecodigo.thunderstructs.models;

import org.academiadecodigo.thunderstructs.services.MockGroupService;

import java.util.LinkedList;
import java.util.List;

public class TournamentGenerator {

     private void setTeamsNames(){
        Teams.ATL_MADRID.setName("Atlético Madrid");
        Teams.BARCELONA.setName("Barcelona");
        Teams.BENFICA.setName("Benfica");
        Teams.LIVERPOOL.setName("Liverpool");
        Teams.MAN_CITY.setName("Manchester City");
        Teams.MAN_UNITED.setName("Manchester United");
        Teams.PORTO.setName("Porto");
        Teams.REAL_MADRID.setName("Real Madrid");
        Teams.SANTA_CLARA.setName("Santa Clara");
        Teams.SPORTING.setName("Sporting");
    }


    public List<Tournament> populate () {

        int id = 1;

         setTeamsNames();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();


        Teams team1 = Teams.MAN_CITY;
        Teams team2 = Teams.ATL_MADRID;
        Teams team3 = Teams.BARCELONA;
        Teams team4 = Teams.BENFICA;



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
        tournament.setName("Taça da Liga");
        tournament.setId(id++);
        tournament.setPlayers(list);
        tournament.setGroups(mockGroupService.getGroupList());
        Tournament tournament1 = new Tournament();
        tournament1.setName("Taça de Portugal");
        tournament1.setId(id++);
        tournament1.setPlayers(list);
        tournament1.setGroups(mockGroupService.getGroupList());
        LinkedList<Tournament> linkedList = new LinkedList<>();
        linkedList.add(tournament);
        linkedList.add(tournament1);
        return linkedList;
    }
}
