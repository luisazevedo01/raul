package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private App app;

    @RequestMapping(method = RequestMethod.GET, value = "/MainMenu")
    public String showMainMenu(Model model){
        model.addAttribute("tournaments", app.getTournamentList());
        return "MainMenu";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/MainMenu")
    public String createTournament(){
        return "tournamentform";
    }

    @Autowired
    public void setApp(App app) {
        this.app = app;
    }
}
