package com.internetshop.controller;

import com.internetshop.entity.security.User;
import com.internetshop.service.security.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class WebController {
    @Autowired
    UsersService usersService;
    String username = "Vasya";

    @RequestMapping(value = { "/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {
        User user = usersService.getCurrentUser();
        model.addAttribute("username", user.getFirstName() + " " + user.getLastName());
        return "index";
    }

}
