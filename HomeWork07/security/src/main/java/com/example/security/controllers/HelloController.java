package com.example.security.controllers;

import com.example.security.services.HelloService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("text", "INDEX PAGE");
        return "index";
    }

    @GetMapping("/")
    public String getHome(Model model) {
        return "redirect:/index";
    }

    @GetMapping("/public-data")
    public String getPublicData(Model model) {
        model.addAttribute("text", "PUBLIC DATA");
        return "index";
    }

    @GetMapping("/private-data")
    public String getPrivateData(Model model) {
        model.addAttribute("text", "PRIVATE DATA: ADMIN ONLY");
        return "index";
    }




}
