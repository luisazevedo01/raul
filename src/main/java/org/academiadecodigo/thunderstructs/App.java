package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.thunderstructs.models.Tournament;
import org.academiadecodigo.thunderstructs.models.User;

import java.util.List;

public class App {

    private List<User> users;
    private List<Tournament> tournamentList;

    public App() {
        populate();
    }

    private void populate(){
        User user1 = new User();
        user1.setName("Luís Ferreta");
        user1.setUsername("luisinho");
        user1.setPassword("123deOliveira4");

        User user2 = new User();
        user2.setName("Beatriz de Almeida com Pires");
        user2.setUsername("bitinha");
        user2.setPassword("1234");

        users.add(user1);
        users.add(user2);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }
}
