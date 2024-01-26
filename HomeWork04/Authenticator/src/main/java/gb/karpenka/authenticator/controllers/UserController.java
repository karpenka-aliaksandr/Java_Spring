package gb.karpenka.authenticator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import gb.karpenka.authenticator.services.*;
import gb.karpenka.authenticator.model.*;



@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/users")
    public String viewUsers(Model model) {
        var users = userService.findAll();
        model.addAttribute("users", users);
        return "users.html";
    }

    @PostMapping("/users")
    public String addUser(
            User u,
            Model model
    ) {
        userService.addProduct(u);

        var users = userService.findAll();
        model.addAttribute("users", users);

        return "users.html";
    }

}
