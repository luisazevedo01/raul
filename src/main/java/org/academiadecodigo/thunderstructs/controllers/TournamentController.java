package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.Group;
import org.academiadecodigo.thunderstructs.models.Player;
import org.academiadecodigo.thunderstructs.models.Tournament;
import org.academiadecodigo.thunderstructs.services.GroupService;
import org.academiadecodigo.thunderstructs.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping ("/tournament")
public class TournamentController {


    private TournamentService tournamentService;
    private GroupService groupService;


    @Autowired
    public void setTournamentService(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showTournament (Model model, @PathVariable Integer id) {

        Tournament tournament = tournamentService.getTournament(id);
        List<Group> groups = tournamentService.getGroups();

        model.addAttribute("tournament", tournament);
        model.addAttribute("groups", groups);

        return "/tournament";
    }

    @RequestMapping


}
