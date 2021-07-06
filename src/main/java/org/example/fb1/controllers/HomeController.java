package org.example.fb1.controllers;

import org.example.fb1.service.DataService;
import org.example.fb1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;
    private final DataService dataService;

    public HomeController(UserService userService, DataService dataService) {
        this.userService = userService;
        this.dataService = dataService;
    }

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        userService.register(username, password);
        return "redirect:/";
    }

    @PostMapping("/data")
    public String postData(@RequestParam("data") String data) {
        dataService.postData(data);
        return "redirect:/";
    }

}
