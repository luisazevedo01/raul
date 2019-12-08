package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginServiceImpl loginServiceImpl;

    @Autowired
    public void setLoginServiceImpl(LoginServiceImpl loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String loginHome(){
        return "login";
    }





}
