package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {

    private MatchService matchService;

    @Autowired
    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/calendar/{id}"})
    public String listMatches(Model model, @PathVariable Integer id) {

        model.addAttribute("matches", matchService.list(id));

        return "/calendar";
    }


}
