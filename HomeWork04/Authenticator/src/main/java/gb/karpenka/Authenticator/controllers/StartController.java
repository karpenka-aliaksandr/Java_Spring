package gb.karpenka.Authenticator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/start")
    public String start() { return "start.html"; }
}
