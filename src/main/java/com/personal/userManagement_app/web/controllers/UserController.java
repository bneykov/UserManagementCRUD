package com.personal.userManagement_app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    public UserController() {

    }

    @GetMapping("/add")
    public String add() {
        return "add-user";
    }

    @GetMapping("/edit")
    public String update() {
        return "update-user";

    }

    @GetMapping("/all")

    public String all() {

        return "all-users";
    }

    @GetMapping("/view")
    public String view() {
        return "view-user";
    }


}
