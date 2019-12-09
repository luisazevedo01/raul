package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.command.UserLoginDto;
import org.academiadecodigo.thunderstructs.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class LoginController {

    private LoginServiceImpl loginServiceImpl;

    @Autowired
    public void setLoginServiceImpl(LoginServiceImpl loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/login", "/"})
    public String loginHome(Model model){
        model.addAttribute("user", new UserLoginDto());
        return "login";
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/login"})
    public String doLogin(@ModelAttribute("user") UserLoginDto userLoginDto){

        loginServiceImpl.authentication(userLoginDto.getUsername(), userLoginDto.getPassword());

        if(!loginServiceImpl.isAuthenticate() || loginServiceImpl.getLoggedUser() == null){
            return "login";
        }
        return "redirect:/MainMenu";
    }

}
