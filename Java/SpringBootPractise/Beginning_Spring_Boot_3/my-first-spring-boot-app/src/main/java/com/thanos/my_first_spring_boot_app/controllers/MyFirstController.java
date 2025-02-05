package com.thanos.my_first_spring_boot_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class MyFirstController {

    @RequestMapping("/")
    public String home(Model model) {
        return "index.html";
    }
}
