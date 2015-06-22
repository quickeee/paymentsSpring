package by.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MainController {
    @RequestMapping("/")
    public String home() {
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")
    public String listContacts() {
        return "index";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login(
            Model model
    ) {
        return "login";
    }

    @RequestMapping(value = "/error.do", method = RequestMethod.GET)
    public String error(
            Model model
    ) {
        return "error";
    }
}
