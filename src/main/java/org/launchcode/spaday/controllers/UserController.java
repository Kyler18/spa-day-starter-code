package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {


   @GetMapping("user/add")
    public String displayAddUserForm(){
        return "add";
   }

    public String processAddUserForm(Model model, @ModelAttribute User user, String verify, String email ) {
        // add form submission handling code here
        String formReturn = "";
        User newUser = new User(user, verify, email);
        if(newUser.getPassword() == verify){
            formReturn = "index";
        }
        else{
            formReturn = "user/add";
        }
        return formReturn;

        model.addAllAttributes("user" , newUser);
    }
}
