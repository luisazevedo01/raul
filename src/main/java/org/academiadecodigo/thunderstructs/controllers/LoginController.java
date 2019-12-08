package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.LoginDto;
import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {

    private LoginServiceImpl loginServiceImpl;

    @Autowired
    public void setLoginServiceImpl(LoginServiceImpl loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/login"})
    public String loginHome(Model model){
        model.addAttribute("login", new LoginDto());
        return "login";
    }

    //controller vai pedir ao service para fazer a autenticação com o username e password que lhe passarem.

    @RequestMapping(method = RequestMethod.POST, path = {"/login"})
    public String doLogin(@ModelAttribute LoginDto loginDto, Model model){

        User user = loginServiceImpl.authentication(loginDto.getUsername(), loginDto.getPassword());

        model.addAttribute("user", user);

        if(loginServiceImpl.isAuthenticate()){
            return "MainMenu";
        }
        return "login";
    }






}
