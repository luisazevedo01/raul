package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private RegisterService registerService;

    @Autowired
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST , path = {"/register"})
    public String register(RedirectAttributes model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if(registerService.saveUser(user)){
            return "redirect:register/" + user.getUsername();
        }

        return "register";
    }

    @RequestMapping(method = RequestMethod.GET , value = "/register/{username}")
    public String show(Model model, @PathVariable String username){

        model.addAttribute("user", registerService.getUser(username));

        return "registerTest";
    }

}
