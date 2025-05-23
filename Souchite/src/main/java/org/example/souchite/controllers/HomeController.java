package com.example.souchite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "index"; // charge le fichier templates/index.html
    }

    @GetMapping("/actions")
    public String showActionsPage() {
        return "actions"; // charge templates/actions.html (à créer)
    }

    @GetMapping("/organisations")
    public String showOrganisationsPage() {
        return "organisations"; // charge templates/organisations.html (à créer)
    }

    @GetMapping("/donner")
    public String showDonationPage() {
        return "donner"; // charge templates/donner.html (à créer)
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // charge templates/login.html (à créer)
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // charge templates/register.html (à créer)
    }
}
