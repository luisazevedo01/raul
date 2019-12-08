package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private GroupService groupService;

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public void setTournamentService(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showTournament (PathVariable Integer id, Model model) {

        model.addAttribute("groups", groupService.getGroupList());
        model.addAttribute("players",tournamentService.ge)


        return "tournament";
    }



}
