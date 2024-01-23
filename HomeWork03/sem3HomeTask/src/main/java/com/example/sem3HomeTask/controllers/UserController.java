package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().addUserToList(user);
        return "User added from body!";
    }
    @GetMapping("/param")
    public String userAddFromParam(@RequestParam Map<String, String> param)
    {
        String name = param.get("name");
        int age = Integer.getInteger(param.get("age"),0);
        String email = param.get("email");

        service.processRegistration(name, age, email);
        return "User added from param!";
    }
}
