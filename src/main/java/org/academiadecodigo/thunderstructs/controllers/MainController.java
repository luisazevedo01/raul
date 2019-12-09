package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.App;
import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.models.Teams;
import org.academiadecodigo.thunderstructs.models.Tournament;
import org.academiadecodigo.thunderstructs.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;


@Controller
public class MainController {

    private App app;


    @Autowired
    private TournamentService service;

    @RequestMapping(method = RequestMethod.GET, value = "/MainMenu")
    public String showMainMenu(Model model){
        model.addAttribute("tournaments", app.getTournamentList());
        return "MainMenu";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/MainMenu")
    public String createTournament(Model model){
        int idCounter = 3;
        Tournament tournament = new Tournament();
        LinkedList<Player> players = new LinkedList<>();
        Player player1 = new Player();
        player1.setName("Filipe");
        player1.setTeam(Teams.BENFICA);
        player1.setScore(0);
        players.add(player1);
        tournament.setPlayers(players);
        tournament.setId(idCounter);
        idCounter++;
        app.getTournamentList().add(tournament);
        model.addAttribute("tournament", tournament);
        return "tournamentform";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addPlayer")
    public String addPlayer(Model model){

        model.addAttribute("player", new Player());
        model.addAttribute("teams", Teams.values());
        return "addplayer";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPlayer")
    public String submitPlayer(Model model,@ModelAttribute Player player, @ModelAttribute Teams team){
        player.setScore(0);
        player.setTeam(team);
        Tournament tournament1 = service.getTournament(2);
        tournament1.getPlayers().add(player);
        model.addAttribute("tournament", tournament1);
        return "tournamentform";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/check")
    public String seeTournaments(Model model){
        model.addAttribute("tournaments", app.getTournamentList());
        return "tournamentTable";
    }


    @Autowired
    public void setApp(App app) {
        this.app = app;
    }



}
