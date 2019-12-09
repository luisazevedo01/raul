package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.App;
import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.models.Team;
import org.academiadecodigo.thunderstructs.models.Tournament;
import org.academiadecodigo.thunderstructs.services.GroupService;
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
        Tournament tournament = new Tournament();
        LinkedList<Player> players = new LinkedList<>();
        tournament.setPlayers(players);
        tournament.setId(2);
        app.getTournamentList().add(tournament);
        model.addAttribute("tournament", new Tournament());
        return "tournamentform";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addPlayer")
    public String addPlayer(Model model){

        model.addAttribute("player", new Player());
        model.addAttribute("team", new Team());
        return "addplayer";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPlayer")
    public String submitPlayer(Model model,@ModelAttribute Player player, @ModelAttribute Team team){
        player.setScore(0);
        player.setTeam(team);
        Tournament tournament1 = service.getTournament(2);
        tournament1.getPlayers().add(player);
        model.addAttribute("tournament", tournament1);
        return "tournamentform";
    }


    @Autowired
    public void setApp(App app) {
        this.app = app;
    }



}
