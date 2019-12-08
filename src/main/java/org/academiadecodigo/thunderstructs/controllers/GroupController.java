package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GroupController {

    private GroupService groupService;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/groups")
    public String getGroups(Model model){

        model.addAttribute("groups", groupService.getGroupList());
        return "groups";
    }
}
